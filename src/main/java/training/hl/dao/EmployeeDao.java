package training.hl.dao;

import java.util.List;

import training.hl.dao.bean.springjdbc.Employee;

/*
 * I will show you how to implement a GenericDao later on
 */
public interface EmployeeDao
{
	public void save(Employee Employee);
	public void delete(Employee Employee);
	public Employee findById(long id);
	public List<Employee> findAll();
}