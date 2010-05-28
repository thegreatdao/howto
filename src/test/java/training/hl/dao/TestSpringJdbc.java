package training.hl.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import training.hl.dao.bean.springjdbc.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestSpringJdbc
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestSpringJdbc.class);
	
	@Autowired
	private DepartMentDao departMentDao;
	
	@Before
	public void setUp()
	{
		LOGGER.info("setup fixture for each test");
	}
	
	@Test
	public void testDepartment()
	{
		List<Department> departments = departMentDao.findAll();
		int initialSize = departments.size();
		Department department = new Department();
		department.setLocation("123 Abc Street");
		department.setName("Human Resource");
		departMentDao.save(department);
		departments = departMentDao.findAll();
		int afterSaveSize = initialSize + 1;
		assertEquals(afterSaveSize, departments.size());
		for(Department dmDepartment : departments)
		{
			LOGGER.info(dmDepartment.toString());
			Department tempDepartment = departMentDao.findById(dmDepartment.getId());
			assertEquals(dmDepartment, tempDepartment);
			departMentDao.delete(dmDepartment);
		}
		departments = departMentDao.findAll();
		assertEquals(0, departments.size());
	}
	
	@Test
	public void testEmployee()
	{
		List<Department> departments = departMentDao.findAll();
		assertEquals(2, departments.size());
	}
}
