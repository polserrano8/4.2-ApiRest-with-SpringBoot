package cat.itacademy.s04.t02.n01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FruitExistsException.class)
    public ResponseEntity<String> handleFruitExist(FruitExistsException e1){
        return new ResponseEntity<>(e1.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(FruitNotExistsException.class)
    public ResponseEntity<String> handleFruitNotExists(FruitNotExistsException e1){
        return new ResponseEntity<>(e1.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
