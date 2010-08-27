package training.hl.report;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.web.servlet.view.jasperreports.JasperReportsHtmlView;

public class CustomJasperReportsHtmlFormatView extends JasperReportsHtmlView
{

	@Override
	protected void renderReport(JasperPrint populatedReport, Map<String, Object> model, HttpServletResponse response) throws Exception
	{
		if (model.containsKey("request"))
		{
			HttpServletRequest request = (HttpServletRequest)model.get("request");
			request.getSession().setAttribute(net.sf.jasperreports.j2ee.servlets.ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, populatedReport);
		}
		super.renderReport(populatedReport, model, response);
	}
	
}
