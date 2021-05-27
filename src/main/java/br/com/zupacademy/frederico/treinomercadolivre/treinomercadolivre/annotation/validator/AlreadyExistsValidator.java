package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.validator;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.AlreadyExists;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class AlreadyExistsValidator implements ConstraintValidator<AlreadyExists, Object> {

    @PersistenceContext
    EntityManager entityManager;
    private Class<?> aClass;
    private String domainAttribute;

    @Override
    public void initialize(AlreadyExists annotation) {
        aClass = annotation.domainClass();
        domainAttribute = annotation.fieldName();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT 1 FROM " +
                aClass.getName()+ " WHERE " + domainAttribute + "= :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}