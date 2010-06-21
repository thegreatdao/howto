package training.hl.dao.hibernate.dedicated;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.bean.RootEntity;

@Repository
@Transactional
public class BaseHibernateDao
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public <T extends RootEntity> void save(T entity)
	{
		hibernateTemplate.saveOrUpdate(entity);
	}
	
	public <T extends RootEntity> void delete(T entity)
	{
		hibernateTemplate.delete(entity);
	}
	
	public <T extends RootEntity, PK extends Serializable> void delete(Class<T> entityClass, PK id)
	{
		T entity = hibernateTemplate.load(entityClass, id);
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
	
    @SuppressWarnings("unchecked")
	public <T extends RootEntity> T findOneByCriteria(Class<T> entityClass, Criterion... criterions)
	{
		Criteria criteria = prepareCriteria(entityClass, criterions);
		return (T)criteria.uniqueResult();
	}
    
    @SuppressWarnings("unchecked")
    public <T extends RootEntity> List<T> findByCriteria(Class<T> entityClass, Criterion... criterions)
    {
    	Criteria criteria = prepareCriteria(entityClass, criterions);
		return criteria.list();
    }
    
    private <T extends RootEntity> Criteria prepareCriteria(Class<T> entityClass, Criterion... criterions)
    {
    	Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(entityClass);
		for(Criterion criterion : criterions)
		{
			criteria.add(criterion);
		}
		return criteria;
    }
}
