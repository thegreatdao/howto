package training.hl.web.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import training.hl.bean.hibernate.User;
import training.hl.bean.hibernate.enums.Gender;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;
import training.hl.exception.TrainingRootException;

@Controller
public class UserController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
    @RequestMapping(method=RequestMethod.GET)
	public @ModelAttribute("users") Collection<User> show()
	{
		return baseHibernateDao.findAll(User.class);
	}
    
    @ModelAttribute("user")
    public User setUpUser(@RequestParam(value = "id", required = false) Long id)
    {
    	User user = new User();
    	if(id != null)
    	{
    		user = baseHibernateDao.findById(User.class, id);
    	}
    	if(user == null)
    	{
    		throw new TrainingRootException("User doesn't exist");
    	}
    	return user;
    }
    
    @RequestMapping(value="/form", method={RequestMethod.GET, RequestMethod.POST})
    public @ModelAttribute("user") User showUser(User user)
    {
    	return user;
    }
    
    @RequestMapping(value="/save", method={RequestMethod.POST})
    public String saveUser(@Valid User user, BindingResult result)
    {
    	if (result.hasErrors())
    	{
			return "user/form";
		}
    	baseHibernateDao.save(user);
    	return "redirect:/user/form.html?id=" + user.getId();
    }
    
    /*
     * jspViewResolver
     */
    @RequestMapping("/ok")
    public @ModelAttribute("user") User ok()
    {
    	User user = new User();
    	user.setAge(10);
    	user.setFirstName("Jim");
    	user.setLastName("Timmins");
    	user.setGender(Gender.MALE);
    	return user;
    }
}