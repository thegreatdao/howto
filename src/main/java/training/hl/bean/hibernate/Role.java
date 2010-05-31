package training.hl.bean.hibernate;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Role extends RootEntity
{

	private static final long serialVersionUID = -4366181788207274076L;

}
