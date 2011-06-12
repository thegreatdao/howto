package training.hl.web.controller;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import training.hl.aop.logging.annotation.Form;
import training.hl.bean.Role;
import training.hl.bean.User;
import training.hl.bean.enums.Gender;
import training.hl.dao.hibernate.dedicated.BaseHibernateDao;
import training.hl.exception.TrainingRootException;
import training.hl.web.util.propertyeditor.RolePropertyEditor;

@Controller
public class UserController
{
	@Autowired
	private BaseHibernateDao baseHibernateDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RolePropertyEditor propertyEditor;
	@Value("${image.upload.folder}")
	private String folderPath;
	
	@InitBinder  
	public void initBinder(WebDataBinder binder)
	{
	    binder.registerCustomEditor(Role.class, propertyEditor);
	}
	
    @RequestMapping(method=RequestMethod.GET)
	public @ModelAttribute("users") Collection<User> show()
	{
		return baseHibernateDao.findAll(User.class);
	}
    
    @ModelAttribute("roles")
    public Collection<Role> setUpRoles()
    {
    	return baseHibernateDao.findAll(Role.class);
    }
    
    @RequestMapping(method=RequestMethod.GET)
    @Form
    public @ModelAttribute("user") User form(Long id)
    {
    	User user = new User();
    	if(id != null)
    	{
    		user = baseHibernateDao.findById(User.class, id);
    	}
    	if(user == null)
		{
			throw new TrainingRootException("User with id " + id + " doesn't exists!");
		}
    	return user;
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method={RequestMethod.POST})
    public String save(@Valid User user, BindingResult result) throws IllegalStateException, IOException, NoSuchAlgorithmException
    {
    	if (result.hasErrors())
    	{
			return "user/form";
		}
    	user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
    	baseHibernateDao.save(user);
    	user.getFile().transferTo(new File(folderPath+uuid() + "." + getSuffix(user.getFile())));
    	return "redirect:/user/form.html?id=" + user.getId();
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method={RequestMethod.GET})
    public String delete(Long id, HttpServletRequest request)
    {
    	String userName = request.getRemoteUser();
    	User userToBeDeleted = baseHibernateDao.findById(User.class, id);
    	if(StringUtils.equals(userName, userToBeDeleted.getUserName()))
    	{
    		throw new TrainingRootException("You cannot delete yourself!");
    	}
    	baseHibernateDao.delete(userToBeDeleted);
    	return "redirect:/user/show.html";
    }
    
    /*
     * jspViewResolver
     */
    @RequestMapping(method={RequestMethod.GET})
    public @ModelAttribute("user") User ok()
    {
    	User user = new User();
    	user.setAge(10);
    	user.setFirstName("Jim");
    	user.setLastName("Timmins");
    	user.setGender(Gender.MALE);
    	return user;
    }
    
    private String uuid() throws NoSuchAlgorithmException
    {
    	long currentTimeMillis = System.currentTimeMillis();
        UUID randomUUID = UUID.randomUUID();

        String uuid = randomUUID.toString() + "-" + currentTimeMillis ;
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(uuid.getBytes());
        byte[] mb = md.digest();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < mb.length; i++)
        {
            byte temp = mb[i];
            String s = Integer.toHexString(new Byte(temp));
            while (s.length() < 2)
            {
                s = "0" + s;
            }
            s = s.substring(s.length() - 2);
            out.append(s.toString());
        }

        return out.toString();
    }
    
    private String getSuffix(CommonsMultipartFile file)
    {
    	String contentType = file.getFileItem().getContentType();
    	if(StringUtils.contains(contentType, "jpeg"))
    	{
    		return "jpg";
    	}
    	else if(StringUtils.containsIgnoreCase(contentType, "png"))
    	{
    		return "png";
    	}
    	return file.getName();
    }
}