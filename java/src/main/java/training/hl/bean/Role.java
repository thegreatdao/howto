package training.hl.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false, exclude = {"users"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Role extends RootEntity
{

	private static final long serialVersionUID = -4366181788207274076L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=6, max=20)
	@Pattern(regexp="ROLE_\\S+")
//	@Unique(entity=Role.class, field="name")
	private String name;
	@NotNull
	@Size(min=10, max=100)
	private String description;
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinTable(name="user_role", joinColumns={@JoinColumn(name="role_id")}, inverseJoinColumns={@JoinColumn(name = "user_id")})
	@XmlTransient
	private Set<User> users = new HashSet<User>();

	//for flex remoting, because flex deserialize null to 0
	public void setId(Long id)
	{
		if(id!=null && id == 0)
		{
			id = null;
		}
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
