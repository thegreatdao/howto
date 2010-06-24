package training.hl.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.bean.Employee;
import training.hl.dao.EmployeeDao;

@Repository("employeeHibernateDao")
@Transactional
public class EmployeeHibernateDaoImpl extends BaseDao implements EmployeeDao
{

	@Override
	public void delete(Employee employee)
	{
		super.delete(employee);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Employee> findAll()
	{
		return findAll(Employee.class);
	}

	@Override
	@Transactional(readOnly=true)
	public Employee findById(long id)
	{
		return findById(Employee.class, id);
	}

	@Override
	public void save(Employee employee)
	{
		super.save(employee);
	}

}
