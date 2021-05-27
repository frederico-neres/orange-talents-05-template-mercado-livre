package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.validator.AlreadyExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AlreadyExistsValidator.class)
public @interface AlreadyExists {

    String message() default "Não existe no banco de dados";

    Class<?>[] groups() default {};

    Class<?  extends Payload>[] payload() default {};

    String  fieldName();

    Class<?> domainClass();
}
