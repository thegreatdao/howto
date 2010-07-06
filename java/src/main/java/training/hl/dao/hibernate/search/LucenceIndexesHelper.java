package training.hl.dao.hibernate.search;

import org.hibernate.classic.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LucenceIndexesHelper
{
	public static void indexWholeDB(HibernateTemplate hibernateTemplate)
	{
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		try
		{
			fullTextSession.createIndexer().purgeAllOnStart(true).optimizeAfterPurge(true).optimizeOnFinish(true).startAndWait();
		}
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
	}
}
