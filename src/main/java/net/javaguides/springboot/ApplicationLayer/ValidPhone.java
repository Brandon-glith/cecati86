
package net.javaguides.springboot.ApplicationLayer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhone {
    String message() default "¡Error inserte un número de telefono valido!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
