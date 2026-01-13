package pl.edu.vistula.project2_shadybekov73429.product.support;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.project2_shadybekov73429.product.support.exception.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public String handle(ProductNotFoundException e) {
        return e.getMessage();
    }
}
