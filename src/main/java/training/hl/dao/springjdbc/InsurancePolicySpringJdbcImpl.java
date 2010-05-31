package training.hl.dao.springjdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.bean.InsurancePolicy;
import training.hl.dao.InsurancePolicyDao;

@Repository("insurancePolicySpringJdbcDao")
@Transactional(readOnly=false)
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
	@Transactional(readOnly=true)
	public List<InsurancePolicy> findAll()
	{
		String sql = "select * from insurance_policy";
		return simpleJdbcTemplate.query(sql, (RowMapper<InsurancePolicy>)ParameterizedBeanPropertyRowMapper.newInstance(InsurancePolicy.class));
	}

	@Override
	@Transactional(readOnly=true)
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
		String sql = "insert into insurance_policy (issurer, policy_number, valid, employee_id) values (:issurer, :policyNumber, :valid, :employeeId)";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("issurer", insurancePolicy.getIssurer());
		parameters.put("policyNumber", insurancePolicy.getPolicyNumber());
		parameters.put("valid", insurancePolicy.isValid());
		parameters.put("employeeId", insurancePolicy.getEmployeeId());
		simpleJdbcTemplate.update(sql, parameters);
	}

}
