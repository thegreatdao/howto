package training.hl.web.controller;

import java.io.File;
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
import training.hl.dao.hibernate.dedicated.UserHibernateDao;

@Controller
public class ReportController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
	public static final String REPORT_IMAGE_DIR = "REPORT_IMAGE_DIR";
	
    @RequestMapping(method=RequestMethod.GET)
	public ModelMap users(String format, HttpServletRequest request)
	{
    	ModelMap model = getModelMap(request);
		Collection<User> users = baseHibernateDao.findAll(User.class);
		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(users, false);
		model.put("usersReportList", jrBeanCollectionDataSource);
		model.put("format", format);
		model.put("request", request);
    	request.getSession().setAttribute("IMAGES_MAP", new HashMap<Object, Object>());
		return model;
	}
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelMap roles(String format, HttpServletRequest request)
    {
    	ModelMap model = getModelMap(request);
    	Collection<Role> users = baseHibernateDao.findAll(Role.class);
    	JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(users, false);
    	model.put("rolesReportList", jrBeanCollectionDataSource);
    	model.put("format", format);
    	return model;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelMap posts(String format, HttpServletRequest request)
    {
    	ModelMap model = getModelMap(request);
    	Collection<Post> users = baseHibernateDao.findAll(Post.class);
    	JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(users, false);
    	model.put("postsReportList", jrBeanCollectionDataSource);
    	model.put("format", format);
    	return model;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelMap categories(String format, HttpServletRequest request)
    {
    	ModelMap model = getModelMap(request);
    	Collection<Category> users = baseHibernateDao.findAll(Category.class);
    	JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(users, false);
    	model.put("categoriesReportList", jrBeanCollectionDataSource);
    	model.put("format", format);
    	return model;
    }
    
    private ModelMap getModelMap(HttpServletRequest request)
    {
    	ModelMap modelMap = new ModelMap();
    	String contextPath = request.getContextPath();
    	String webBaseDirString = request.getSession().getServletContext().getRealPath(contextPath);
		File webBaseDir = new File(webBaseDirString);
    	File imagesDir = new File(webBaseDir, "images");
    	String reportImageDir = imagesDir.getPath() + System.getProperty("file.separator");
    	modelMap.put(REPORT_IMAGE_DIR, reportImageDir);
    	return modelMap;
    }
}
