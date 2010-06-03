package training.hl.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.util.Version;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import training.hl.bean.RootEntity;

@Repository
public class BaseDao
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

	public <PK extends Serializable, T extends RootEntity> T findById(PK id,
			Class<T> entityClass)
	{
		return hibernateTemplate.get(entityClass, id);
	}

	public <T extends RootEntity> List<T> findAll(Class<T> entityClass)
	{
		return hibernateTemplate.loadAll(entityClass);
	}

	@SuppressWarnings("unchecked")
	public <T extends RootEntity> List<T> findBySearch(String[] fields, Class<T> entityClass, String searchTerm)
	{
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		Transaction tx = fullTextSession.beginTransaction();
		MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_29, fields, new StandardAnalyzer(Version.LUCENE_29));

		try
		{
			org.apache.lucene.search.Query query = parser.parse(searchTerm);
			FullTextQuery hibQuery = fullTextSession.createFullTextQuery(query,entityClass);
			tx.commit();
			return hibQuery.list();

		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public void indexWholeDB()
	{
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		fullTextSession.createIndexer().purgeAllOnStart(false).optimizeAfterPurge(true).optimizeOnFinish(true).start();

	}
}
