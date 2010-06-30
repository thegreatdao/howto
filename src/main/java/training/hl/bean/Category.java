package training.hl.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper=false, exclude={"posts"})
@ToString(callSuper=false, exclude="posts")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Category extends RootEntity
{
	private static final long serialVersionUID = 2495573965088461445L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=2, max=20)
//	@Unique(entity = Category.class, field = "name")
	private String name;
	@Column(insertable=false, updatable=false)
	private Date createdDate;
	@XmlTransient
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	private Set<Post> posts = new HashSet<Post>();
	@ManyToOne
	@XmlTransient
	@JoinColumn(name="user_id")
	private User user;
}
