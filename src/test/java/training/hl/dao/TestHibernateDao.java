package training.hl.dao;

import static ch.lambdaj.Lambda.filter;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;

import java.util.List;

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
import training.hl.dao.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestHibernateDao
{
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(TestHibernateDao.class);
	
	@Autowired
	@Qualifier("departmentHibernateDao")
	private DepartMentDao departMentDao;
	@Autowired
	@Qualifier("employeeHibernateDao")
	private EmployeeDao employeeDao;
	@Autowired
	@Qualifier("insurancePolicyHibernateDao")
	private InsurancePolicyDao insurancePolicyDao;
	
	@Test
	public void testDepartment()
	{
		Department department = new Department();
		department.setLocation("Scarborough");
		department.setName("Accounting");
		departMentDao.save(department);
		List<Department> departments = departMentDao.findAll();		
		List<Department> singleDepartment = filter(having(on(Department.class).getName(), equalToIgnoringCase("Accounting")), departments);
		assertEquals(1, singleDepartment.size());
		assertEquals(singleDepartment.get(0), department);
		departMentDao.delete(department);
		departments = departMentDao.findAll();
		List<Department> zeorDepartments = filter(having(on(Department.class).getName(), equalToIgnoringCase("Accounting")), departments);
		assertEquals(0, zeorDepartments.size());
		for(Department tempDepartment : departments)
		{
			Department foundDepartment = departMentDao.findById(tempDepartment.getId());
			assertEquals(foundDepartment, tempDepartment);
		}
	}
	
	@Test
	public void testEmployee()
	{
		Employee employee = new Employee();
		employee.setAge(20);
		employee.setFirstName("Bill");
		employee.setLastName("Black");
		Department department = departMentDao.findById(1l);
		employee.setDepartmentId(department.getId());
		employeeDao.save(employee);
		List<Employee> employees = employeeDao.findAll();
		List<Employee> singleEmployee = filter(having(on(Employee.class).getFirstName(), equalToIgnoringCase("Bill")), employees);
		assertEquals(1, singleEmployee.size());
		assertEquals(employee, singleEmployee.get(0));
		employeeDao.delete(employee);
		employees = employeeDao.findAll();
		List<Employee> zeroEmployee = filter(having(on(Employee.class).getFirstName(), equalToIgnoringCase("Bill")), employees);
		assertEquals(0, zeroEmployee.size());
	}
	
	@Test
	public void testInsurance()
	{
		
	}
}
