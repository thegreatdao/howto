package training.hl.bean.hibernate;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Post extends RootEntity
{
	private static final long serialVersionUID = -731165606859766533L;
	private Long id;
	private String title;
	private String body;
	private User user;
	private Category category;
}
