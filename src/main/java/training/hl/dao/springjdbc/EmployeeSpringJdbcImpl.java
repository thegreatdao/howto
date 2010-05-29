package training.hl.dao.springjdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import training.hl.dao.EmployeeDao;
import training.hl.dao.bean.springjdbc.Employee;

@Repository
public class EmployeeSpringJdbcImpl implements EmployeeDao
{
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public void delete(Employee employee)
	{
		String sql = "delete from employee where id = :id";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", employee.getId());
		simpleJdbcTemplate.update(sql, parameters);	
	}

	@Override
	public List<Employee> findAll()
	{
		String sql = "select * from employee";
		return simpleJdbcTemplate.query(sql, (RowMapper<Employee>)ParameterizedBeanPropertyRowMapper.newInstance(Employee.class));
	}

	@Override
	public Employee findById(long id)
	{
		String sql = "select * from employee where id = :id";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);
		return simpleJdbcTemplate.queryForObject(sql, (RowMapper<Employee>)ParameterizedBeanPropertyRowMapper.newInstance(Employee.class), parameters);
	}

	@Override
	public void save(Employee employee)
	{
		String sql = "insert into employee (first_name, last_name, age, department_id, insurance_policy_id) " +
				"values (:firstName, :lastName, :age, :departmentId, :insurancePolicyId)";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("firstName", employee.getFirstName());
		parameters.put("lastName", employee.getLastName());
		parameters.put("age", employee.getAge());
		parameters.put("departmentId", employee.getDepartmentId());
		parameters.put("insurancePolicyId", employee.getInsurancePolicyId());
		simpleJdbcTemplate.update(sql, parameters);
	}


}
