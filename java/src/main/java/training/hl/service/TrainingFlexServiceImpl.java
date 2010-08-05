package training.hl.service;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

import training.hl.bean.Role;
import training.hl.bean.User;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

@Service("trainingFlexService")
@RemotingDestination
public class TrainingFlexServiceImpl implements TrainingFlexService
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Collection<User> getAllUsers()
	{
		return baseHibernateDao.findAll(User.class);
	}

	@Override
	public void saveUser(User user)
	{
		Set<Role> roles = user.getRoles();
		for(Role role : roles)
		{
			role = baseHibernateDao.findById(Role.class, role.getId());
		}
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
		baseHibernateDao.save(user);
	}

	@Override
	public void saveRole(Role role)
	{
		baseHibernateDao.save(role);
	}

	@Override
	public Collection<Role> getAllRoles()
	{
		return baseHibernateDao.findAll(Role.class);
	}
}
