package training.hl.dao.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true, includeFieldNames=true)
public class Department extends RootEnitity
{
	private static final long serialVersionUID = 6493743908873389064L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;
	@OneToMany(mappedBy="department", fetch=FetchType.EAGER)
	private List<Employee> employees;
}
