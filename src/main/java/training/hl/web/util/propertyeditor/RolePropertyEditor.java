package training.hl.web.util.propertyeditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import training.hl.bean.Role;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

@Component
public class RolePropertyEditor extends PropertyEditorSupport
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
	@Override
	public void setAsText(String text)
	{
		super.setValue(baseHibernateDao.findById(Role.class, Long.parseLong(text)));
	}
	
}
