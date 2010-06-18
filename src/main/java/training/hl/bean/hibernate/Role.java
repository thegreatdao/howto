package training.hl.bean.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	private String name;
	private String description;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
}
