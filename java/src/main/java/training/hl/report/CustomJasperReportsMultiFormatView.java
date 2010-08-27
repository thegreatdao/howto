package training.hl.report;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.joda.time.DateTime;
import org.springframework.web.servlet.view.jasperreports.JasperReportsCsvView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsView;

public class CustomJasperReportsMultiFormatView extends JasperReportsMultiFormatView
{
	
	@SuppressWarnings("unchecked")
	public CustomJasperReportsMultiFormatView()
	{
		Map<String, Class> formatMappings = new HashMap<String, Class>(4);
		formatMappings.put("csv", JasperReportsCsvView.class);
		formatMappings.put("html", CustomJasperReportsHtmlFormatView.class);
		formatMappings.put("pdf", JasperReportsPdfView.class);
		formatMappings.put("xls", JasperReportsXlsView.class);
		setFormatMappings(formatMappings);
	}

	@Override
	protected void renderReport(JasperPrint populatedReport, Map<String, Object> model, HttpServletResponse response) throws Exception 
	{
        // replace content disposition header filename with the report names.
        Properties contentDispositions = new Properties();
        //contentDispositions.put("html", "attachment; filename=_dummy_.html");
        contentDispositions.put("pdf", "attachment; filename=_dummy_.pdf");
        contentDispositions.put("xls", "attachment; filename=_dummy_.xls");
        contentDispositions.put("csv", "attachment; filename=_dummy_.csv");
        this.setContentDispositionMappings(contentDispositions);
        
        Enumeration<Object> enumContDispKeys = contentDispositions.keys();
        // iterate over all disposition mappings and replace the word _dummy_ with the reportName
        while(enumContDispKeys.hasMoreElements())
        {
            Object contDispKey = enumContDispKeys.nextElement();
            // check whether string before cast.
            if(contDispKey instanceof String)
            {
                // get the disposition string
                String dispositionStr = contentDispositions.getProperty((String)contDispKey);
                // set the new value in the properties
                DateTime now = new DateTime();
                String fileName = populatedReport.getName() + now.toString("_yyyy_MM_dd_hh_mm_ss");
                contentDispositions.setProperty((String)contDispKey,dispositionStr.replace("_dummy_", fileName));
            }
        }
        super.renderReport(populatedReport,model,response);
	}
}
