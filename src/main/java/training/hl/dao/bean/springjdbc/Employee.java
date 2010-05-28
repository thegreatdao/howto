package training.hl.dao.bean.springjdbc;

import lombok.Data;

import org.springframework.stereotype.Component;

@Data
@Component
public class Employee
{
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private Gender gender;
	private Long departmentId;
	private Long insurancePolicyId;
	
	enum Gender
	{
		MALE,
		FEMALE
	}
}
