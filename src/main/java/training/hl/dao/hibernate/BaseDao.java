package training.hl.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import training.hl.dao.bean.RootEnitity;

public abstract class BaseDao
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public <T extends RootEnitity> void save(T entity)
	{
		hibernateTemplate.save(entity);
	}
	
	public <T extends RootEnitity> void delete(T entity)
	{
		hibernateTemplate.delete(entity);
	}
	
	public <PK extends Serializable, T extends RootEnitity> T findById(PK id, Class<T> entityClass)
	{
		return hibernateTemplate.get(entityClass, id);
	}
	
	public <T extends RootEnitity> List<T> findAll(Class<T> entityClass)
	{
		return hibernateTemplate.loadAll(entityClass);
	}
}
