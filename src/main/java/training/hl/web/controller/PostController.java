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

import training.hl.bean.hibernate.Post;
import training.hl.bean.hibernate.User;
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
	
	@ModelAttribute("post")
	public Post setUp(@RequestParam(value = "id", required = false) Long id)
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
	
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public @ModelAttribute("post") Post show(Post post)
    {
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
    public String delete(Post post)
    {
    	baseHibernateDao.delete(post);
    	return "redirect:/post/show.html";
    }
}
