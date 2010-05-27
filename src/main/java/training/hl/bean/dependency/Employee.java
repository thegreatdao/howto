package training.hl.bean.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Employee
{
	private String firstName;
	private String lastName;
	private int age;
	private Gender sex;
	private Department department;
	@Autowired
	private InsurancePolicy insurancePolicy;
	
	@Autowired
	public Employee(Department department)
	{
		this.department = department;
	}
	
	enum Gender
	{
		MALE,
		FEMALE
	}
		
}
