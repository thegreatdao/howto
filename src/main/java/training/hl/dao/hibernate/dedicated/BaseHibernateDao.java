package training.hl.dao.hibernate.dedicated;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.bean.hibernate.RootEntity;

@Repository
@Transactional
public class BaseHibernateDao
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public <T extends RootEntity> void save(T entity)
	{
		hibernateTemplate.save(entity);
	}
	
	public <T extends RootEntity> void delete(T entity)
	{
		hibernateTemplate.delete(entity);
	}
	
	public <T extends RootEntity, PK extends Serializable> T findById(Class<T> entityClass, PK id)
	{
		return hibernateTemplate.get(entityClass, id);
	}
	
	public <T extends RootEntity> Collection<T> findAll(Class<T> entityClass)
	{
		return hibernateTemplate.loadAll(entityClass);
	}
}
