package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.validator;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> aClass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue annotation) {
        domainAttribute = annotation.fieldName();
        aClass = annotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT 1 FROM " +
                aClass.getName()+ " WHERE " + domainAttribute + "= :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        Assert.isTrue(list.size() <= 1, "Foi encontrado mais de um "
                +aClass+ " com o atributo " +domainAttribute+ " = "+value);

        return list.isEmpty();
    }
}