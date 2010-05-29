package training.hl.dao.bean.springjdbc;

import lombok.Data;

@Data
public class InsurancePolicy
{
	private Long id;
	private String policyNumber;
	private boolean valid;
	private String issuer;
}
