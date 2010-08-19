package training.hl.messaging;

import javax.jms.Destination;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import training.hl.bean.Role;

@Component
public class MessageProducer
{
	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(final String message)
	{
		DateTime dateTime = new DateTime();
		int suffix = dateTime.getDayOfYear() + dateTime.getHourOfDay() + dateTime.getMinuteOfDay() + dateTime.getSecondOfDay();
		Role role = new Role();
		role.setName("ROLE_" + suffix);
		role.setDescription("role created by scheduler " + suffix);
		jmsTemplate.convertAndSend(destination, role);
	}
}
