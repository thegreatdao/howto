package training.hl.web.controller;

import java.util.Collection;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping(value="/form.html", method=RequestMethod.GET)
    public @ModelAttribute("user") User showUser(@RequestParam(value = "id") long id)
    {
    	return baseHibernateDao.findById(User.class, id);
    }
    
    /*
     * jspViewResolver
     */
    @RequestMapping("/ok.html")
    public String ok()
    {
    	return "user/ok";
    }
}