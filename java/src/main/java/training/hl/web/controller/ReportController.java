package training.hl.web.controller;

import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import training.hl.bean.Category;
import training.hl.bean.Post;
import training.hl.bean.Role;
import training.hl.bean.User;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

@Controller
public class ReportController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
    @RequestMapping(method=RequestMethod.GET)
	public ModelMap users(String format, HttpServletRequest request)
	{
    	ModelMap model = new ModelMap();
		Collection<User> users = baseHibernateDao.findAll(User.class);
		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(users, false);
		model.put("usersReportList", jrBeanCollectionDataSource);
		model.put("format", format);
		model.put("request", request);
    	request.getSession().setAttribute("IMAGES_MAP", new HashMap<Object, Object>());
		return model;
	}
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelMap roles(String format)
    {
    	ModelMap model = new ModelMap();
    	Collection<Role> users = baseHibernateDao.findAll(Role.class);
    	JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(users, false);
    	model.put("rolesReportList", jrBeanCollectionDataSource);
    	model.put("format", format);
    	return model;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelMap posts(String format)
    {
    	ModelMap model = new ModelMap();
    	Collection<Post> users = baseHibernateDao.findAll(Post.class);
    	JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(users, false);
    	model.put("postsReportList", jrBeanCollectionDataSource);
    	model.put("format", format);
    	return model;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelMap categories(String format)
    {
    	ModelMap model = new ModelMap();
    	Collection<Category> users = baseHibernateDao.findAll(Category.class);
    	JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(users, false);
    	model.put("categoriesReportList", jrBeanCollectionDataSource);
    	model.put("format", format);
    	return model;
    }
}
