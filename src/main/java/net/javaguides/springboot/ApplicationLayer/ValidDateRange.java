package net.javaguides.springboot.ApplicationLayer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DateRangeValidator.class) // Asocia el validador
@Target({ ElementType.TYPE }) // Se aplica a clases
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRange {

    String message() default "La fecha de terminación debe ser mayor que la fecha de inicio";

    Class<?>[] groups() default {}; // Para agrupar las validaciones

    Class<? extends Payload>[] payload() default {}; // Para proporcionar información adicional
}
