package training.hl.scheduler;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import training.hl.bean.Role;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

@Component
public class CronUserScheduler
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
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
}
