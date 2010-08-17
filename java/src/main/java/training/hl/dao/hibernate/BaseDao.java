package training.hl.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.util.Version;
import org.hibernate.classic.Session;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.bean.RootEntity;
import training.hl.exception.TrainingRootException;

@Repository
@Transactional
public class BaseDao
{
	@Autowired
	protected HibernateTemplate hibernateTemplate;

	public <T extends RootEntity> void save(T entity)
	{
		hibernateTemplate.saveOrUpdate(entity);
	}
	
	public <T extends RootEntity> void merge(T entity)
	{
		hibernateTemplate.merge(entity);
	}

	public <T extends RootEntity> void delete(T entity)
	{
		hibernateTemplate.delete(entity);
	}

	@Transactional(readOnly=true)
	public <PK extends Serializable, T extends RootEntity> T findById(Class<T> entityClass, PK id)
	{
		return hibernateTemplate.get(entityClass, id);
	}

	@Transactional(readOnly=true)
	public <T extends RootEntity> List<T> findAll(Class<T> entityClass)
	{
		return hibernateTemplate.loadAll(entityClass);
	}

	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public <T extends RootEntity> List<T> findBySearch(String[] fields, Class<T> entityClass, String searchTerm)
	{
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_29, fields, new StandardAnalyzer(Version.LUCENE_29));

		try
		{
			org.apache.lucene.search.Query query = parser.parse(searchTerm);
			FullTextQuery hibQuery = fullTextSession.createFullTextQuery(query,entityClass);
			return hibQuery.list();
		}
		catch (ParseException e)
		{
			throw new TrainingRootException(e);
		}
		
	}
}
