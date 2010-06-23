package training.hl.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import training.hl.bean.hibernate.Category;
import training.hl.bean.hibernate.Post;
import training.hl.bean.hibernate.User;
import training.hl.bean.hibernate.enums.Gender;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;
import training.hl.dao.hibernate.search.LucenceIndexesHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestRealHibernateDao
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private BaseDao baseDao;
	
	@Before
	public void setUP()
	{
		LucenceIndexesHelper.indexWholeDB(hibernateTemplate);
	}
	
	@Test
	public void testCompositions()
	{
		Category category = new Category();
		category.setName("Groovy");
		User user = new User();
		user.setUserName("First_User");
		user.setPassword("First_User_PASSWORD");
		user.setAge(20);
		user.setFirstName("Peter");
		user.setLastName("Johnson");
		user.setGender(Gender.MALE);
		Post post = new Post();
		post.setBody("Groovy is a dynamic language that enables user rapid develepment with ease... " + user);
		post.setTitle("What is Spring's subproject Groovy?");
		user.addCategory(category);
		baseHibernateDao.save(user);
		post.setCategoryId(category.getId());
		post.setUser(user);
		baseHibernateDao.save(post);
		Collection<Category> categories = baseHibernateDao.findAll(Category.class);
		assertEquals(4, categories.size());
		User foundUser = baseHibernateDao.findById(User.class, 10l);
		assertEquals(foundUser, user);
		User secondUser = baseHibernateDao.findById(User.class, 1l);
		assertEquals(1, secondUser.getPosts().size());
		Collection<Post> allPosts = baseHibernateDao.findAll(Post.class);
		assertEquals(2, allPosts.size());
		List<Post> posts = baseDao.findBySearch(new String[]{"title"}, Post.class, "spring");
		int size = posts.size();
		assertTrue(size == 2);
	}
}
