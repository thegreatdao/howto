package training.hl.dao;

import java.util.List;

import training.hl.bean.Department;
/*
 * I will show you how to implement a GenericDao later on
 */
public interface DepartMentDao
{
	public void save(Department department);
	public void delete(Department department);
	public Department findById(long id);
	public List<Department> findAll();
}
