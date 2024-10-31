package net.javaguides.springboot.ApplicationLayer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailDuplicateChecker.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "El correo electrónico ingresado"
            + " ya está en uso. Por favor, utiliza otro correo"
            + " o inicia sesión si ya tienes una cuenta.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
