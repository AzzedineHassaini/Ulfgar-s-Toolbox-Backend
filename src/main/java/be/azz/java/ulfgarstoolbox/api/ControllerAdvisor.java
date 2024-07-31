package be.azz.java.ulfgarstoolbox.api;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotFoundException;
import be.azz.java.ulfgarstoolbox.common.exceptions.ResourceAccessDeniedException;
import be.azz.java.ulfgarstoolbox.common.exceptions.auth.LoginFailedException;
import be.azz.java.ulfgarstoolbox.common.exceptions.auth.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
        log.warn(e.toString());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage()); //406
    }

    @ExceptionHandler({LoginFailedException.class})
    public ResponseEntity<String> handleUserNotFoundException(LoginFailedException e) {
        log.warn(e.toString());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage()); //406
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handleUserNotFoundException(NotFoundException e) {
        log.warn(e.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //404
    }

    @ExceptionHandler(ResourceAccessDeniedException.class)
    public ResponseEntity<String> handleUserNotFoundException(ResourceAccessDeniedException e) {
        log.warn(e.toString());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage()); // 403
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors =
                e.getBindingResult().getAllErrors()
                        .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .distinct().toList();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errors); // 406
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        log.error(e.toString());
        return ResponseEntity.badRequest().body(e); // 400
    }

}

