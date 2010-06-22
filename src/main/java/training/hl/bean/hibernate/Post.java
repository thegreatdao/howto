package training.hl.bean.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import training.hl.bean.RootEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=false)
@Indexed
public class Post extends RootEntity
{
	private static final long serialVersionUID = -731165606859766533L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Field(index=Index.TOKENIZED, store=Store.NO)
	@NotNull
	@Size(min=6, max=100)
	private String title;
	@NotNull
	@Size(min=10, max=1000)
	private String body;
	@Column(insertable=false, updatable=false)
	private Date createdDate;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
}
