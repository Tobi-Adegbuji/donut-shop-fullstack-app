package dev.tobiadegbuji.donut.backend.donut_shop_backend.exception;

import dev.tobiadegbuji.donut.backend.donut_shop_backend.controllers.DonutController;
import dev.tobiadegbuji.donut.backend.donut_shop_backend.exception.validation.ValidationError;
import dev.tobiadegbuji.donut.backend.donut_shop_backend.exception.validation.ValidationErrorCreator;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice(assignableTypes = {DonutController.class})
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = ResourceNotFoundException.class)
    private ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        Map<String, Object> body = new LinkedHashMap<>(); //Keeping insertion order
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("message", exception.getResourceName() + " was not found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String,Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());

        ValidationError errors = ValidationErrorCreator.createValidationError(ex.getBindingResult());
        body.put("message", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
