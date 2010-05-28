package training.hl.dao.springjdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import training.hl.dao.DepartMentDao;
import training.hl.dao.bean.springjdbc.Department;

@Repository
public class DepartMentSpringJdbcImpl implements DepartMentDao
{
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public void delete(Department department)
	{
		String sql = "delete from department where id = :id";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", department.getId());
		simpleJdbcTemplate.update(sql, parameters);
	}

	@Override
	public Department findById(long id)
	{
		String sql = "select * from department where id = :id";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);
		return simpleJdbcTemplate.queryForObject(sql, (RowMapper<Department>)ParameterizedBeanPropertyRowMapper.newInstance(Department.class), parameters);
	}

	@Override
	public void save(Department department)
	{
		String sql = "insert into department (name, location) values (:name, :location)";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", department.getName());
		parameters.put("location", department.getLocation());
		simpleJdbcTemplate.update(sql, parameters);
	}

	@Override
	public List<Department> findAll()
	{
		String sql = "select * from department";
		return simpleJdbcTemplate.query(sql, (RowMapper<Department>)ParameterizedBeanPropertyRowMapper.newInstance(Department.class));
	}

}
