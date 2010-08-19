package training.hl.messaging;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

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
		jmsTemplate.convertAndSend(destination, message);
	}
}
