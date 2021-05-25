package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.exceptionHandler;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.exceptionHandler.dto.ArgumentError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ArgumentsNotValidException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentsException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<ArgumentError> errors = new ArrayList<>();

        fieldErrors.forEach(fieldError -> {
            errors.add(new ArgumentError(fieldError.getField(), fieldError.getDefaultMessage()));
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
