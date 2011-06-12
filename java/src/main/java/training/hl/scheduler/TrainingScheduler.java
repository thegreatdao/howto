package training.hl.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import training.hl.jmx.TrainingJmxBean;
import training.hl.messaging.MessageProducer;

@Component
public class TrainingScheduler
{
	protected static final Logger LOG = LoggerFactory.getLogger(TrainingScheduler.class);
	
	@Autowired
	private MessageProducer messageProducer;
	@Autowired
	private TrainingJmxBean trainingJmxBean;
	
	/*
	 * create a robot user every 30sec
	 */
	@Scheduled(fixedRate=30000)
	public void sendJMSPojo()
	{
		messageProducer.sendNewRole();
	}
	
	@Scheduled(fixedRate=60000)
	public void monitorJmxBeanAttribute()
	{
		LOG.info("------------------- JMX BEAN ATTRIBUTE IS : " + trainingJmxBean.getSuffix());
//		LOG.error("triggering a sound! enjoy");
	}
}
