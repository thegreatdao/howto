package training.hl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class InsurancePolicy extends RootEntity
{
	private static final long serialVersionUID = 5805528164968512210L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String policyNumber;
	private boolean valid;
	private String issurer;
	@Column(name="employee_id")
	private Long employeeId;
}
