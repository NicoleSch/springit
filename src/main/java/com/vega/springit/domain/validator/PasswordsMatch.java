package com.vega.springit.domain.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

// basic, wie Annotation im Normalfall aussieht

@Documented
@Constraint(validatedBy = PasswordsMatchValidator.class)
// @Constraint sagt, dass die Annotation sicherstellen soll, dass Annotierte Methode von der Klasse validiert werden soll
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsMatch {

  String message() default "Password & Password Confirmation do not match.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
