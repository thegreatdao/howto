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
import training.hl.bean.hibernate.enums.Gender;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

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
		User user = new User();
		user.setAge(20);
		user.setFirstName("Peter");
		user.setLastName("Johnson");
		user.setGender(Gender.MALE);
		Post post = new Post();
		post.setBody("This is post created by " + user);
		post.setTitle("a test post");
		baseHibernateDao.save(user);
		baseHibernateDao.save(category);
		post.setCategory(category);
		post.setUser(user);
		baseHibernateDao.save(post);
		Collection<Category> categories = baseHibernateDao.findAll(Category.class);
		assertEquals(3, categories.size());
		User foundUser = baseHibernateDao.findById(User.class, 2l);
		assertEquals(foundUser, user);
		User secondUser = baseHibernateDao.findById(User.class, 1l);
		assertEquals(1, secondUser.getPosts().size());
		Collection<Post> allPosts = baseHibernateDao.findAll(Post.class);
		assertEquals(2, allPosts.size());
	}
}
