package training.hl.dao.hibernate;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import training.hl.bean.hibernate.Category;
import training.hl.bean.hibernate.dao.BaseHibernateDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestRealHibernateDao
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
	@Test
	public void testCompositions()
	{
		Category category = new Category();
		category.setName("Category");
		baseHibernateDao.save(category);
		Collection<Category> categories = baseHibernateDao.findAll(Category.class);
		assertEquals(1, categories.size());
	}
}
