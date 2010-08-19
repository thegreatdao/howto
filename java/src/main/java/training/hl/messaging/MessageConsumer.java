package training.hl.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer implements MessageListener
{
	protected static final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);
	
	@Override
	public void onMessage(final Message message)
	{
		if(message instanceof TextMessage)
		{
			final TextMessage textMessage = (TextMessage)message;
			try
			{
				LOG.info(textMessage.getText());
			}
			catch (final JMSException e)
			{
				LOG.error("jsm error: ", e);
			}
		}
	}
}
