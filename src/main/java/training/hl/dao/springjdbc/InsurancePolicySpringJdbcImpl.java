package training.hl.dao.springjdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import training.hl.dao.InsurancePolicyDao;
import training.hl.dao.bean.springjdbc.InsurancePolicy;

@Repository
public class InsurancePolicySpringJdbcImpl implements InsurancePolicyDao
{
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public void delete(InsurancePolicy insurancePolicy)
	{
		String sql = "delete from insurance_policy where id = :id";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", insurancePolicy.getId());
		simpleJdbcTemplate.update(sql, parameters);
	}

	@Override
	public List<InsurancePolicy> findAll()
	{
		String sql = "select * from insurance_policy";
		return simpleJdbcTemplate.query(sql, (RowMapper<InsurancePolicy>)ParameterizedBeanPropertyRowMapper.newInstance(InsurancePolicy.class));
	}

	@Override
	public InsurancePolicy findById(long id)
	{
		String sql = "select * from insurance_policy where id = :id";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);
		return simpleJdbcTemplate.queryForObject(sql, (RowMapper<InsurancePolicy>)ParameterizedBeanPropertyRowMapper.newInstance(InsurancePolicy.class), parameters);
	}

	@Override
	public void save(InsurancePolicy insurancePolicy)
	{
		String sql = "insert into insurance_policy (issurer, policy_number, valid) values (:issurer, :policyNumber, :valid)";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("issurer", insurancePolicy.getIssuer());
		parameters.put("policyNumber", insurancePolicy.getPolicyNumber());
		parameters.put("valid", insurancePolicy.isValid());
		simpleJdbcTemplate.update(sql, parameters);
	}

}
