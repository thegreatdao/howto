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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper=false, exclude={"posts"})
@ToString(callSuper=false, exclude="posts")
public class Category extends RootEntity
{
	private static final long serialVersionUID = 2495573965088461445L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(insertable=false, updatable=false)
	private Date createdDate;
	@OneToMany(mappedBy="category")
	private Set<Post> posts = new HashSet<Post>();

}
