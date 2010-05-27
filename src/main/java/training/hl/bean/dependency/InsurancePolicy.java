package training.hl.bean.dependency;

import lombok.Data;

@Data
public class InsurancePolicy
{
	private String policyNumber;
	private boolean valid;
	private String issuer;
}
