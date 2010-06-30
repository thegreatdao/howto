package training.hl.bean.ws;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import training.hl.bean.Role;

import lombok.Data;

@Data
@XmlRootElement
public class Roles implements Serializable
{
	private static final long serialVersionUID = 6385732612925556230L;
	private Collection<Role> roles;
	
	@XmlElement(name="role")
	public Collection<Role> getRoles()
	{
		return roles;
	}
}
