package training.hl.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import training.hl.bean.hibernate.Role;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

@Controller
public class RoleController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ModelAttribute("roles") Collection<Role> show()
	{
		return baseHibernateDao.findAll(Role.class);
	}
}
