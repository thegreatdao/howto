package training.hl.dao.hibernate.dedicated;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.bean.RootEntity;
import training.hl.bean.pagination.Pagination;
import training.hl.dao.hibernate.BaseDao;

/*
 * inherited transaction from BaseDao
 */
@Repository
public class BaseHibernateDao extends BaseDao
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public <T extends RootEntity, PK extends Serializable> void delete(Class<T> entityClass, PK id)
	{
		T entity = hibernateTemplate.load(entityClass, id);
		hibernateTemplate.delete(entity);
	}
	
	@Transactional(readOnly=true)
    @SuppressWarnings("unchecked")
	public <T extends RootEntity> T findOneByCriteria(Class<T> entityClass, Criterion... criterions)
	{
		Criteria criteria = prepareCriteria(entityClass, criterions);
		return (T)criteria.uniqueResult();
	}
    
	@Transactional(readOnly=true)
    @SuppressWarnings("unchecked")
    public <T extends RootEntity> List<T> findByCriteria(Class<T> entityClass, Criterion... criterions)
    {
    	Criteria criteria = prepareCriteria(entityClass, criterions);
		return criteria.list();
    }
	
	public void executeByNamedQuery(String namedQuery, Map<String, Object> parameters)
	{
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().getNamedQuery(namedQuery);
		for(Map.Entry<String, Object> entry : parameters.entrySet())
		{
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	private <T extends RootEntity> T uniqueResultFromNamedQuery(String namedQuery, Map<String, Object> parameters)
	{
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().getNamedQuery(namedQuery);
		for(Map.Entry<String, Object> entry : parameters.entrySet())
		{
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return (T) query.uniqueResult();
	}
	
	public void deleteEntityByNamedQueryResult(String namedQuery, Map<String, Object> parameters)
	{
		delete(uniqueResultFromNamedQuery(namedQuery, parameters));
	}
	
	@SuppressWarnings("unchecked")
	public <T extends RootEntity> Pagination<T> getPaginatedCollection(Class<T> entityClass, int currentIndex, int numOfRecordsPerPage, String sortField, boolean asc)
	{
		Pagination<T> pagination = new Pagination<T>();
		Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(entityClass);
		criteria.setProjection(Projections.rowCount());
		pagination.setTotalNumOfRecords((Long)criteria.uniqueResult());
		criteria.setProjection(null);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.setFirstResult(currentIndex * numOfRecordsPerPage);
        criteria.setMaxResults(numOfRecordsPerPage);
        if(asc)
        {
        	criteria.addOrder(Order.asc(sortField));
        }
        else
        {
        	criteria.addOrder(Order.desc(sortField));
        }
        Collection<T> records = criteria.list();
        pagination.setCurrentIndex(currentIndex);
        pagination.setRecords(records);
        pagination.setNumOfRecordsPerPage(numOfRecordsPerPage);
		return pagination;
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
