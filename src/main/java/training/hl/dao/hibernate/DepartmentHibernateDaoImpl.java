package training.hl.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.hl.dao.DepartMentDao;
import training.hl.dao.bean.Department;

@Repository("departmentHibernateDao")
@Transactional(readOnly=false)
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
		return findById(id, Department.class);
	}

	@Override
	public void save(Department department)
	{
		super.save(department);
	}

}
