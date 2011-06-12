package training.hl.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import training.hl.bean.enums.Gender;

@Data
@Entity
@EqualsAndHashCode(callSuper = false, exclude = { "posts", "categories", "roles"})
@ToString(callSuper = false, exclude = { "posts", "categories", "roles"})
@JsonIgnoreProperties(value={"categories", "roles", "posts", "password", "profile"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries
(
	{
		@NamedQuery(name = User.DELETE_USER_BY_USERNAME, query = "delete from User where userName=:userName"),
		@NamedQuery(name = User.FIND_USER_BY_USERNAME, query = "from User where userName=:userName"),
		@NamedQuery(name = User.FIND_USERS_WITH_CATEGORIES_EAGER_LOADED, query = "from User")
	}
)
public class User extends RootEntity
{
	private static final long serialVersionUID = 5840474281304089091L;
	public static final String DELETE_USER_BY_USERNAME = "deleteUserByUsername";
	public static final String FIND_USER_BY_USERNAME = "findUserByUserName";
	public static final String FIND_USERS_WITH_CATEGORIES_EAGER_LOADED = "findUsersWithCategoriesEagerLoaded";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=1, max=20)
//	@Unique(entity=User.class, field="userName")
	private String userName;
	@NotNull
	@Size(min=6, max=65)
	@XmlTransient
	private String password;
	@NotNull
	@Size(min=1, max=20)
	private String firstName;
	@NotNull
	@Size(min=1, max=20)
	private String lastName;
	@NotNull
	@Min(10)
	@Max(80)
	private Integer age;
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	private String icon;
	private String image;
	@XmlTransient
	@Transient
	private CommonsMultipartFile file;
	@Column(insertable=false, updatable=false)
	private Date createdDate;
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@XmlTransient
	private Set<Post> posts = new HashSet<Post>();
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@XmlTransient
	private Set<Category> categories = new HashSet<Category>();
	@Embedded
	private Profile profile;
	@NotNull
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinTable(name="user_role", joinColumns={@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name = "role_id")})
	@XmlElement(name="role")
	private Set<Role> roles = new HashSet<Role>();
	
	public void addCategory(Category category)
	{
		category.setUser(this);
		categories.add(category);
	}
	
	/*
	* some ugly hack
	* for flex remoting, because flex deserialize null to 0, have to change identity start value to non-zero value
	*/
	public void setId(Long id)
	{
		if(id == null || id == 0)
		{
			id = null;
		}
		this.id = id;
	}
}
