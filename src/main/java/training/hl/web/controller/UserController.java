package training.hl.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import training.hl.bean.hibernate.User;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
    @RequestMapping(value="/show", method=RequestMethod.GET)
	public @ModelAttribute("users") Collection<User> show()
	{
		return baseHibernateDao.findAll(User.class);
	}
}
