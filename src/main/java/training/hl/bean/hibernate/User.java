package training.hl.bean.hibernate;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import training.hl.bean.hibernate.enums.Gender;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
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
	private Date createDates;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private Set<Post> posts;
}
