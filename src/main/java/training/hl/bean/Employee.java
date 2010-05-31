package training.hl.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=false, includeFieldNames=true)
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
    @JoinColumn(name="department_id", insertable=false, updatable=false)
    private Department department;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Set<InsurancePolicy> insurancePolicies;
}
