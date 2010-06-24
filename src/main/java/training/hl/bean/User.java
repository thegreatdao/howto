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
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import training.hl.bean.enums.Gender;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper = false, exclude = { "posts", "categories", "roles" })
@ToString(callSuper = false, exclude = { "posts", "categories", "roles" })
public class User extends RootEntity
{
	private static final long serialVersionUID = 5840474281304089091L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=1, max=20)
	private String userName;
	@NotNull
	@Size(min=6, max=65)
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
	@Column(insertable=false, updatable=false)
	private Date createdDate;
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL, CascadeType.REMOVE})
	private Set<Post> posts = new HashSet<Post>();
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private Set<Category> categories = new HashSet<Category>();
	@Embedded
	private Profile profile;
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinTable(name="user_role", joinColumns={@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<Role>();
	
	public void addCategory(Category category)
	{
		category.setUser(this);
		categories.add(category);
	}
}
