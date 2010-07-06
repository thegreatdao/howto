package training.hl.hibernate.util;

import static org.hibernate.criterion.DetachedCriteria.forClass;
import static org.hibernate.criterion.Projections.count;
import static org.hibernate.criterion.Restrictions.eq;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import training.hl.hibernate.annotation.Unique;

public class UniqueConstraintValidator implements ConstraintValidator<Unique, String>
{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	private Class<?> entity;
	private String field;

	public void initialize(Unique annotation)
	{
		this.entity = annotation.entity();
		this.field = annotation.field();
	}

	public boolean isValid(String value, ConstraintValidatorContext context)
	{
		if (StringUtils.isEmpty(value))
		{
			return false;
		}
		return query(value).intValue() == 0;
	}

	private Number query(String value)
	{
		DetachedCriteria criteria = forClass(entity).add(eq(field, value)).setProjection(count(field));
		return (Number) hibernateTemplate.findByCriteria(criteria).iterator().next();
	}

}
