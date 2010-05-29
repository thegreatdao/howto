package training.hl.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import training.hl.dao.EmployeeDao;
import training.hl.dao.bean.springjdbc.Employee;

@Repository
public class EmployeeHibernateDaoImpl implements EmployeeDao
{

	@Override
	public void delete(Employee employee)
	{
		
	}

	@Override
	public List<Employee> findAll()
	{
		return null;
	}

	@Override
	public Employee findById(long id)
	{
		return null;
	}

	@Override
	public void save(Employee employee)
	{
		
	}

}
