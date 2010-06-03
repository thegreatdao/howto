package training.hl.bean.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import training.hl.bean.RootEntity;
import training.hl.bean.hibernate.enums.Gender;

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
	private String firstName;
	private String lastName;
	private int age;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	@Column(insertable = false, updatable = false)
	private Date createdDate;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Post> posts = new HashSet<Post>();
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Category> categories = new HashSet<Category>();
	@Embedded
	private Profile profile;
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>();
	
	public void addCategory(Category category)
	{
		category.setUser(this);
		categories.add(category);
	}
}
