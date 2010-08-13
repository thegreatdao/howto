package training.hl.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
	public User saveUser(User user)
	{
		Set<Role> roles = user.getRoles();
		for(Role role : roles)
		{
			role = baseHibernateDao.findById(Role.class, role.getId());
		}
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
		baseHibernateDao.save(user);
		return user;
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

	@Override
	public void deleteUser(Long userId)
	{
		baseHibernateDao.delete(User.class, userId);
	}

	@Override
	public void deleteUserByUsername(String userName)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userName", userName);
		baseHibernateDao.deleteEntityByNamedQueryResult(User.FIND_USER_BY_USERNAME, parameters);
	}
}
