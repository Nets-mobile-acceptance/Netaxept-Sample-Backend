package eu.nets.ms.pia.service.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = { RegisterRequestValidator.class })
public @interface ValidRegisterRequest {
	String message() default "Invalid register request";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
