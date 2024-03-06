package dev.patika.ecommerce.core.config;

import dev.patika.ecommerce.core.exceptions.NotFoundException;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultWithData;
import dev.patika.ecommerce.core.utils.Msg;
import dev.patika.ecommerce.core.utils.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(ResultHelper.notFoundError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultWithData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e){
        List<String> validationErrorList = e.getBindingResult()
                .getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).toList();
        return new ResponseEntity<>(ResultHelper.validateError(validationErrorList), HttpStatus.BAD_REQUEST);
    }
}
