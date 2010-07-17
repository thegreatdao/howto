package training.hl.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import training.hl.bean.User;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

@Service("trainingFlexService")
@RemotingDestination
public class TrainingFlexServiceImpl implements TrainingFlexService
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
	@Override
	public Collection<User> getAllUsers()
	{
		return baseHibernateDao.findAll(User.class);
	}
}
