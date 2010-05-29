package training.hl.dao;

import java.util.List;

import training.hl.dao.bean.springjdbc.InsurancePolicy;

/*
 * I will show you how to implement a GenericDao later on
 */
public interface InsurancePolicyDao
{
	public void save(InsurancePolicy insurancePolicy);
	public void delete(InsurancePolicy insurancePolicy);
	public InsurancePolicy findById(long id);
	public List<InsurancePolicy> findAll();
}
