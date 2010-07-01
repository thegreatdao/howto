package training.hl.web.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import training.hl.bean.Category;
import training.hl.bean.Role;
import training.hl.bean.User;
import training.hl.bean.ws.Categories;
import training.hl.bean.ws.Roles;
import training.hl.bean.ws.Users;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;

@Controller
@Path("/ws")
public class TrainingResource
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("data/roles")
	public Roles getRoles()
	{
		Roles roles = new Roles();
		roles.setRoles(baseHibernateDao.findAll(Role.class));
		return roles;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("data/roles/{id}")
	public Role getRole(@PathParam("id") long id)
	{
		return baseHibernateDao.findById(Role.class, id);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("data/categories")
	public Categories getCategories()
	{
		Categories categories = new Categories();
		categories.setCategories(baseHibernateDao.findAll(Category.class));
		return categories;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("data/categories/{id}")
	public Category getCategory(@PathParam("id") long id)
	{
		return baseHibernateDao.findById(Category.class, id);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("data/users")
	public Users getUsers()
	{
		Users users = new Users();
		users.setUsers(baseHibernateDao.findAll(User.class));
		return users;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("data/users/{id}")
	public User getUser(@PathParam("id") long id)
	{
		return baseHibernateDao.findById(User.class, id);
	}
}
