package training.hl.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "spring:name=trainingJmxBean", description = "our training JMX-managed beand")
public class TrainingJmxBean
{
	public String something;

	@ManagedAttribute
	public String getSomething()
	{
		return something;
	}

	public void setSomething(String something)
	{
		this.something = something;
	}
	
}
