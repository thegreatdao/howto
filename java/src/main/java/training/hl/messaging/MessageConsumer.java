package training.hl.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import training.hl.bean.Role;

@Component
public class MessageConsumer implements MessageListener
{
	protected static final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);
	
	@Override
	public void onMessage(final Message message)
	{
		if(message instanceof ObjectMessage)
		{
			ObjectMessage objectMessage = (ObjectMessage)message;
			try
			{
				Role role = (Role)objectMessage.getObject();
				LOG.info(role.toString());
			}
			catch (final JMSException e)
			{
				LOG.error("jsm error: ", e);
			}
		}
	}
}
