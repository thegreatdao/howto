package training.hl.jmx;

import org.apache.commons.lang.StringUtils;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "training:name=trainingJmxBean", description = "our training JMX-managed bean")
public class TrainingJmxBean
{
	private String suffix;

	@ManagedAttribute
	public String getSuffix()
	{
		if(StringUtils.isEmpty(suffix))
		{
			return "";
		}
		return suffix;
	}

	@ManagedAttribute
	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}

}
