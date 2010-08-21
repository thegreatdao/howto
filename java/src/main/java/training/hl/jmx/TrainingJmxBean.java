package training.hl.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "spring:name=trainingJmxBean", description = "our training JMX-managed bean")
public class TrainingJmxBean
{
	private String something;

	@ManagedAttribute
	public String getSomething()
	{
		return something;
	}

	@ManagedAttribute
	public void setSomething(String something)
	{
		this.something = something;
	}
	
}
