package training.hl.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import training.hl.bean.Category;
import training.hl.bean.Post;
import training.hl.bean.User;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;
import training.hl.exception.TrainingRootException;

@Controller
public class PostController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ModelAttribute("posts") Collection<Post> show()
	{
		return baseHibernateDao.findAll(Post.class);
	}
	
	@ModelAttribute("categories")
	public Collection<Category> setUpCategory()
	{
		Collection<Category> categories = baseHibernateDao.findAll(Category.class);
		return categories;
	}
	
    @RequestMapping(method={RequestMethod.GET})
    public @ModelAttribute("post") Post form(Long id)
    {
    	Post post = new Post();
		if (id != null)
		{
			post = baseHibernateDao.findById(Post.class, id);
		}
		if(post == null)
		{
			throw new TrainingRootException("Post with id " + id + " doesn't exists!");
		}
		return post;
    }
    
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method={RequestMethod.POST})
    public String save(@Valid Post post, BindingResult result, HttpServletRequest request)
    {
    	if (result.hasErrors())
    	{
			return "post/form";
		}
    	Criterion criterion = Restrictions.eq("userName", request.getRemoteUser());
    	User user = baseHibernateDao.findOneByCriteria(User.class, criterion);
    	post.setUser(user);
    	baseHibernateDao.save(post);
    	return "redirect:/post/form.html?id=" + post.getId();
    }
	
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method={RequestMethod.GET})
    public String delete(Long id)
    {
    	baseHibernateDao.delete(Category.class, id);
    	return "redirect:/post/show.html";
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/post/search")
    public String findPostsByTitle(String title, Model model)
    {
    	if(StringUtils.isBlank(title))
    	{
    		model.addAttribute("posts", baseHibernateDao.findAll(Post.class));
    	}
    	else
    	{
    		model.addAttribute("posts", baseHibernateDao.findBySearch(new String[]{"title"}, Post.class, title));
    	}
    	return "post/show";
    }
}
