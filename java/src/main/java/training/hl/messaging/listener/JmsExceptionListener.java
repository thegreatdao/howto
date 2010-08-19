package training.hl.messaging.listener;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JmsExceptionListener implements ExceptionListener
{

	protected static final Logger LOG = LoggerFactory.getLogger(JmsExceptionListener.class);
	
	@Override
	public void onException(final JMSException e)
	{
		LOG.error("error occured for jms messaging", e);
	}
}
