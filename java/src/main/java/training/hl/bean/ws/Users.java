package training.hl.bean.ws;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import training.hl.bean.User;

@Data
@XmlRootElement
public class Users implements Serializable
{
	private static final long serialVersionUID = -3964840879357561056L;
	
	private Collection<User> users;

	@XmlElement(name="user")
	public Collection<User> getUsers() {
		return users;
	}
}
