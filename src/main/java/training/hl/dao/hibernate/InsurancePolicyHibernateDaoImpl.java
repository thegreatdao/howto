package training.hl.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.dao.InsurancePolicyDao;
import training.hl.dao.bean.InsurancePolicy;

@Repository("insurancePolicyHibernateDao")
@Transactional(readOnly=false)
public class InsurancePolicyHibernateDaoImpl extends BaseDao implements InsurancePolicyDao
{

	@Override
	public void delete(InsurancePolicy insurancePolicy)
	{
		super.delete(insurancePolicy);
	}

	@Override
	@Transactional(readOnly=true)
	public List<InsurancePolicy> findAll()
	{
		return super.findAll(InsurancePolicy.class);
	}

	@Override
	@Transactional(readOnly=true)
	public InsurancePolicy findById(long id)
	{
		return findById(id, InsurancePolicy.class);
	}

	@Override
	public void save(InsurancePolicy insurancePolicy)
	{
		super.save(insurancePolicy);
	}

}
