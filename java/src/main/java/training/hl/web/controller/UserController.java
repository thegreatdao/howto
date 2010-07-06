package training.hl.web.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import training.hl.aop.logging.annotation.Form;
import training.hl.bean.Role;
import training.hl.bean.User;
import training.hl.bean.enums.Gender;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;
import training.hl.exception.TrainingRootException;
import training.hl.web.util.propertyeditor.RolePropertyEditor;

@Controller
public class UserController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RolePropertyEditor propertyEditor;
	
	@InitBinder  
	public void initBinder(WebDataBinder binder)
	{
	    binder.registerCustomEditor(Role.class, propertyEditor);
	}
	
    @RequestMapping(method=RequestMethod.GET)
	public @ModelAttribute("users") Collection<User> show()
	{
		return baseHibernateDao.findAll(User.class);
	}
    
    @ModelAttribute("user")
    public User setUp(@RequestParam(value = "id", required = false) Long id)
    {
    	User user = new User();
    	if(id != null)
    	{
    		user = baseHibernateDao.findById(User.class, id);
    	}
    	if(user == null)
		{
			throw new TrainingRootException("User with id " + id + " doesn't exists!");
		}
    	return user;
    }
    
    @ModelAttribute("roles")
    public Collection<Role> setUpRoles()
    {
    	return baseHibernateDao.findAll(Role.class);
    }
    
    @RequestMapping(method=RequestMethod.GET)
    @Form
    public @ModelAttribute("user") User form(User user)
    {
    	return user;
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method={RequestMethod.POST})
    public String save(@Valid User user, BindingResult result)
    {
    	if (result.hasErrors())
    	{
			return "user/form";
		}
    	user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
    	baseHibernateDao.save(user);
    	return "redirect:/user/form.html?id=" + user.getId();
    }
    
    @PreAuthorize("#user.userName != principal.username and hasRole('ROLE_ADMIN')")
    @RequestMapping(method={RequestMethod.GET})
    public String delete(User user)
    {
    	baseHibernateDao.delete(user);
    	return "redirect:/user/show.html";
    }
    
    /*
     * jspViewResolver
     */
    @RequestMapping(method={RequestMethod.GET})
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