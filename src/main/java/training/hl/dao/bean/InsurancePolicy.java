package training.hl.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="insurance_policy")
@EqualsAndHashCode(callSuper=false)
public class InsurancePolicy extends RootEnitity
{
	private static final long serialVersionUID = 5805528164968512210L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="policy_number")
	private String policyNumber;
	private boolean valid;
	private String issurer;
	@Column(name="employee_id")
	private Long employeeId;
}
