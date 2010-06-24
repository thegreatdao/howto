package training.hl.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.bean.Department;
import training.hl.dao.DepartMentDao;

@Repository("departmentHibernateDao")
@Transactional
public class DepartmentHibernateDaoImpl extends BaseDao implements DepartMentDao
{

	@Override
	public void delete(Department department)
	{
		super.delete(department);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Department> findAll()
	{
		return findAll(Department.class);
	}

	@Override
	@Transactional(readOnly=true)
	public Department findById(long id)
	{
		return findById(Department.class, id);
	}

	@Override
	public void save(Department department)
	{
		super.save(department);
	}

}
