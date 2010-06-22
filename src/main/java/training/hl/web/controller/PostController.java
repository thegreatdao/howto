package training.hl.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import training.hl.bean.hibernate.Post;
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
		if (post == null)
		{
			throw new TrainingRootException("Role doesn't exist");
		}
		return post;
	}
}
