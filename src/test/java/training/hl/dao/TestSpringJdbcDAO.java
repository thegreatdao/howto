package training.hl.dao;

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
import training.hl.dao.bean.InsurancePolicy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestSpringJdbcDao
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestSpringJdbcDao.class);
	
	@Autowired
	@Qualifier("departmentSpringJdbcDao")
	private DepartMentDao departMentDao;
	@Autowired
	@Qualifier("employeeSpringJdbcDao")
	private EmployeeDao employeeDao;
	@Autowired
	@Qualifier("insurancePolicySpringJdbcDao")
	private InsurancePolicyDao insurancePolicyDao;
	
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
		List<Employee> employees = employeeDao.findAll();
		int initialSize = employees.size();
		Employee employee = new Employee();
		employee.setAge(20);
		employee.setDepartmentId(1l);
		employee.setFirstName("Bill");
		employee.setLastName("Black");
		employeeDao.save(employee);
		employees = employeeDao.findAll();
		int afterSaveSize = employees.size();
		assertEquals(initialSize + 1, afterSaveSize);
		for(Employee emlEmployee : employees)
		{
			LOGGER.info(emlEmployee.toString());
			Employee tempEmployee = employeeDao.findById(emlEmployee.getId());
			assertEquals(emlEmployee, tempEmployee);
			employeeDao.delete(emlEmployee);
		}
		employees = employeeDao.findAll();
		assertEquals(0, employees.size());
	}
	
	@Test
	public void testInsurancePolicy()
	{
		List<InsurancePolicy> insurancePolicies = insurancePolicyDao.findAll();
		int initialSize = insurancePolicies.size();
		InsurancePolicy insurancePolicy = new InsurancePolicy();
		insurancePolicy.setIssurer("HEALTH-WARRANTY");
		insurancePolicy.setPolicyNumber("HW1234567890");
		insurancePolicy.setValid(true);
		insurancePolicy.setEmployeeId(1l);
		insurancePolicyDao.save(insurancePolicy);
		insurancePolicies = insurancePolicyDao.findAll();
		int afterSaveSize = insurancePolicies.size();
		assertEquals(initialSize + 1, afterSaveSize);
		for(InsurancePolicy insPolicy : insurancePolicies)
		{
			LOGGER.info(insPolicy.toString());
			InsurancePolicy tempInsurancePolicy = insurancePolicyDao.findById(insPolicy.getId());
			assertEquals(insPolicy, tempInsurancePolicy);
			insurancePolicyDao.delete(insPolicy);
		}
		insurancePolicies = insurancePolicyDao.findAll();
		assertEquals(0, insurancePolicies.size());
	}
}
