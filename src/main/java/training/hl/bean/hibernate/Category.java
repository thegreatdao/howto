package training.hl.bean.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category extends RootEntity
{
	private static final long serialVersionUID = 2495573965088461445L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Set<Post> getPosts()
	{
		return posts;
	}

	public void setPosts(Set<Post> posts)
	{
		this.posts = posts;
	}

	@OneToMany(mappedBy="category")
	private Set<Post> posts = new HashSet<Post>();
	
	public void addPost(Post post)
	{
		post.setCategory(this);
		posts.add(post);
	}
}
