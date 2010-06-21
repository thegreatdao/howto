package training.hl.web.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import training.hl.bean.hibernate.Category;
import training.hl.bean.hibernate.Role;
import training.hl.bean.hibernate.User;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;
import training.hl.exception.TrainingRootException;

@Controller
public class CategoryController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ModelAttribute("categories") Collection<Category> show()
	{
		return baseHibernateDao.findAll(Category.class);
	}
	
	@ModelAttribute("category")
	public Category setUp(@RequestParam(value = "id", required = false) Long id)
	{
		Category category = new Category();
		if (id != null)
		{
			category = baseHibernateDao.findById(Category.class, id);
		}
		if (category == null)
		{
			throw new TrainingRootException("Role doesn't exist");
		}
		return category;
	}
	
	@RequestMapping(value="/category/form", method={RequestMethod.GET, RequestMethod.POST})
    public @ModelAttribute("category") Category show(Category category)
    {
    	return category;
    }
	
	@PreAuthorize("#category.user.userName == principal.username  or hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/category/save", method={RequestMethod.POST})
    public String save(@Valid Category category, BindingResult result)
    {
    	if (result.hasErrors())
    	{
			return "category/form";
		}
    	category.setUser(baseHibernateDao.findById(User.class, 0l));
    	baseHibernateDao.save(category);
    	return "redirect:/category/form.html?id=" + category.getId();
    }
}
