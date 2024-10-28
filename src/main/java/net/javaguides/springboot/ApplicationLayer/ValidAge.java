package net.javaguides.springboot.ApplicationLayer;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AgeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAge {
    String message() default "¡Debes tener al menos 15 años para preinscribirse a un curso!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
