package training.hl.bean;

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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;


@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=false)
@Indexed
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Post extends RootEntity
{
	private static final long serialVersionUID = -731165606859766533L;
	@Id
	@DocumentId
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
	@XmlTransient
	private User user;
	@NotNull
	@Column(name="category_id")
	private Long categoryId;
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="category_id",insertable=false, updatable=false)
	private Category category;
}
