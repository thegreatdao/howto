package training.hl.bean.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import training.hl.bean.hibernate.enums.Gender;

@Entity
public class User extends RootEntity
{
	private static final long serialVersionUID = 5840474281304089091L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private Gender gender;
	@SuppressWarnings("unused")
	@Column(insertable=false, updatable=false)
	private Date createdDate;
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	public Set<Post> getPosts()
	{
		return posts;
	}

	public void setPosts(Set<Post> posts)
	{
		this.posts = posts;
	}

	@OneToMany(mappedBy="user", cascade={CascadeType.MERGE, CascadeType.PERSIST})
	private Set<Post> posts = new HashSet<Post>();
	
	public void addPost(Post post)
	{
		post.setUser(this);
		posts.add(post);
	}
}
