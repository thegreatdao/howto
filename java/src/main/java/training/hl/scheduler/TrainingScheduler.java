package training.hl.scheduler;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import training.hl.bean.Role;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;
import training.hl.jmx.TrainingJmxBean;
import training.hl.messaging.MessageProducer;

@Component
public class TrainingScheduler
{
	protected static final Logger LOG = LoggerFactory.getLogger(TrainingScheduler.class);
	
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	@Autowired
	private MessageProducer messageProducer;
	@Autowired
	private TrainingJmxBean trainingJmxBean;
	
	/*
	 * create a robot user every 30sec
	 */
	@Scheduled(fixedRate=30000)
	public void createRole()
	{
		DateTime dateTime = new DateTime();
		int suffix = dateTime.getDayOfYear() + dateTime.getHourOfDay() + dateTime.getMinuteOfDay() + dateTime.getSecondOfDay();
		Role role = new Role();
		role.setName("ROLE_" + suffix);
		role.setDescription("role created by scheduler " + suffix);
		baseHibernateDao.save(role);
	}
	
	/*
	 * create a robot user every 30sec
	 */
	@Scheduled(fixedRate=30000)
	public void jsmPlainMessage()
	{
		DateTime dateTime = new DateTime();
		messageProducer.send("message sent at : " + dateTime);
	}
	
	@Scheduled(fixedRate=6000)
	public void monitorJmxBeanAttribute()
	{
		LOG.info("------------------- JMX BEAN ATTRIBUTE IS : " + trainingJmxBean.getSomething());
	}
}
