package training.hl.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.dao.EmployeeDao;
import training.hl.dao.bean.Employee;

@Repository("employeeHibernateDao")
@Transactional(readOnly=false)
public class EmployeeHibernateDaoImpl implements EmployeeDao
{

	@Override
	public void delete(Employee employee)
	{
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Employee> findAll()
	{
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public Employee findById(long id)
	{
		return null;
	}

	@Override
	public void save(Employee employee)
	{
		
	}

}
