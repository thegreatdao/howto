package training.hl.bean.dependency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class TestSpringDI
{
	@Autowired
	private Employee employee;
	
	@Test
	public void testEmployeeDI()
	{
		Department department = employee.getDepartment();
		assertEquals("Toronto", department.getLocation());
		assertEquals("head office", department.getName());
		InsurancePolicy insurancePolicy = employee.getInsurancePolicy();
		assertEquals("sunLife", insurancePolicy.getIssuer());
		assertEquals("sun-life-1234567890", insurancePolicy.getPolicyNumber());
	}
}
