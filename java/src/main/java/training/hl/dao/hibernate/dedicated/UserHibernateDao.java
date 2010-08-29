package training.hl.dao.hibernate.dedicated;

import java.util.Collection;

import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import training.hl.bean.User;

@Repository
public class UserHibernateDao extends BaseHibernateDao
{
	@SuppressWarnings("unchecked")
	public Collection<User> findUsersWithCategoriesEagerLoaded()
	{
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Collection<User> users = session.getNamedQuery(User.FIND_USERS_WITH_CATEGORIES_EAGER_LOADED).list();
		return users;
	}
}
