package training.hl.hibernate.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import training.hl.hibernate.util.UniqueConstraintValidator;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UniqueConstraintValidator.class)
@Documented
public @interface Unique
{
    String message() default "{constraints.unique}";
    Class<?> entity();
    String field();
    Class<?>[] groups() default {};   
    Class<? extends Payload>[] payload() default {};
}