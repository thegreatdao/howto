package training.hl.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import training.hl.bean.Category;
import training.hl.bean.User;
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
	
	@RequestMapping(method=RequestMethod.GET)
    public @ModelAttribute("category") Category form(@RequestParam(value = "id", required = false) Long id)
    {
		Category category = new Category();
		if (id != null)
		{
			category = baseHibernateDao.findById(Category.class, id);
		}
		if(category == null)
		{
			throw new TrainingRootException("Category with id " + id + " doesn't exists!");
		}
    	return category;
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method={RequestMethod.POST})
    public String save(@Valid Category category, BindingResult result, HttpServletRequest request)
    {
    	if (result.hasErrors())
    	{
			return "category/form";
		}
    	Criterion criterion = Restrictions.eq("userName", request.getRemoteUser());
    	User user = baseHibernateDao.findOneByCriteria(User.class, criterion);
    	category.setUser(user);
    	baseHibernateDao.save(category);
    	return "redirect:/category/form.html?id=" + category.getId();
    }
	
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method={RequestMethod.GET})
    public String delete(Category category)
    {
    	baseHibernateDao.delete(category);
    	return "redirect:/category/show.html";
    }
}
