package training.hl.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import training.hl.dao.bean.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestHibernateDao
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestHibernateDao.class);
	
	@Autowired
	@Qualifier("departmentHibernateDao")
	private DepartMentDao departMentDao;
	
	@Before
	public void setUP()
	{
		LOGGER.info(departMentDao.toString());
	}
	
	@Test
	public void testDepartment()
	{
		int initialSize = departMentDao.findAll().size();
		Department department = new Department();
		department.setLocation("Scarborough");
		department.setName("Accounting");
		departMentDao.save(department);
		int afterSaveSize = departMentDao.findAll().size();
		assertEquals(initialSize + 1, afterSaveSize);
		departMentDao.delete(department);
		List<Department> departments = departMentDao.findAll();
		int afterDeletionSize = departments.size();
		assertEquals(initialSize, afterDeletionSize);
		for(Department tempDepartment : departments)
		{
			Department foundDepartment = departMentDao.findById(tempDepartment.getId());
			assertEquals(foundDepartment, tempDepartment);
		}
	}
	
	@Test
	public void testEmployee()
	{
		
	}
}
