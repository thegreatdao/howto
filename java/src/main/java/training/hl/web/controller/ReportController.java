package training.hl.web.controller;

import java.util.Collection;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import training.hl.bean.User;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

@Controller
public class ReportController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	
    @RequestMapping(method=RequestMethod.GET)
	public JRBeanCollectionDataSource users()
	{
		Collection<User> users = baseHibernateDao.findAll(User.class);
		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(users, false);
		return jrBeanCollectionDataSource;
	}
}
