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
import training.hl.bean.hibernate.Post;
import training.hl.bean.hibernate.User;
import training.hl.bean.hibernate.dao.BaseHibernateDao;
import training.hl.bean.hibernate.enums.Gender;

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
		assertEquals(2, categories.size());
		User user = new User();
		user.setAge(20);
		user.setFirstName("Peter");
		user.setLastName("Johnson");
		user.setGender(Gender.MALE);
		Post post = new Post();
		post.setBody("This is post created by " + user);
		post.setTitle("a test post");
		user.addPost(post);
		baseHibernateDao.save(user);
		User foundusUser = baseHibernateDao.findById(User.class, 2l);
		assertEquals(foundusUser, user);
	}
}
