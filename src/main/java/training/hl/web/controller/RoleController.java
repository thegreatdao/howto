package training.hl.web.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import training.hl.bean.Role;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;
import training.hl.exception.TrainingRootException;

@Controller
public class RoleController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;

	@RequestMapping(method = RequestMethod.GET)
	public @ModelAttribute("roles") Collection<Role> show()
	{
		return baseHibernateDao.findAll(Role.class);
	}

	@ModelAttribute("role")
	public Role setUp(@RequestParam(value = "id", required = false) Long id)
	{
		Role role = new Role();
		if (id != null)
		{
			role = baseHibernateDao.findById(Role.class, id);
		}
		if(role == null)
		{
			throw new TrainingRootException("Role with id " + id + " doesn't exists!");
		}
		return role;
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public @ModelAttribute("role") Role form(Role role)
    {
    	return role;
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method={RequestMethod.POST})
    public String save(@Valid Role role, BindingResult result)
    {
		if(role.getId() != null)
		{
			Role roleUser = baseHibernateDao.findById(Role.class, role.getId());
			if(StringUtils.equals(roleUser.getName(), "ROLE_USER"))
			{
				throw new TrainingRootException("ROLE_USER is a fixed role which is read-only");
			}
		}
    	if (result.hasErrors())
    	{
			return "role/form";
		}
    	baseHibernateDao.save(role);
    	return "redirect:/role/form.html?id=" + role.getId();
    }
    
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method={RequestMethod.GET})
    public String delete(Role role)
    {
		if(StringUtils.equals(role.getName(),"ROLE_USER"))
		{
			throw new TrainingRootException("ROLE_USER is a fixed role which is read-only");
		}
    	baseHibernateDao.delete(role);
    	return "redirect:/role/show.html";
    }
	  
	/*
	@RequestMapping(value="/role/save", method={RequestMethod.POST})
    public ModelAndView saveRole(@Valid Role role, BindingResult result)
    {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("role", role);
    	if (result.hasErrors())
    	{
    		modelAndView.setViewName("role/form");
			return modelAndView;
		}
    	if(role.getId() == null)
    	{
    		modelAndView.addObject("key", "role.successfully.created");
    	}
    	else
    	{
    		modelAndView.addObject("key", "role.successfully.updated");
    	}
    	baseHibernateDao.save(role);
    	modelAndView.setViewName("redirect:/role/form.html?id=" + role.getId());
    	return modelAndView;
    }
    */
}
