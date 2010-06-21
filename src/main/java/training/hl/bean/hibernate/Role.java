package training.hl.bean.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import training.hl.bean.RootEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper = false, exclude = { "users"})
@ToString(callSuper = false, exclude = { "users"})
public class Role extends RootEntity
{
	private static final long serialVersionUID = -4366181788207274076L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=6, max=20)
	@Pattern(regexp="ROLE_\\S+")
	private String name;
	@NotNull
	@Size(min=10, max=100)
	private String description;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
}
