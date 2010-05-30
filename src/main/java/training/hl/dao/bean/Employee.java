package training.hl.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Employee extends RootEnitity
{
	private static final long serialVersionUID = 3085808750192155928L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private int age;
	@Column(name="department_id")
	private Long departmentId;
	@ManyToOne
	@JoinColumn(name="department_id", nullable = false,insertable=false,updatable=false)
	private Department department;
	@Column(name="insurance_policy_id", nullable = false,insertable=false,updatable=false)
	private InsurancePolicy insurancePolicy;
	@Column(name="insurance_policy_id")
	private Long insurancePolicyId;
}
