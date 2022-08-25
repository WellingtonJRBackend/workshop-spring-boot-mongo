package wp.mongodb.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import wp.mongodb.services.exception.ObjectNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFound (ObjectNotFoundException e , HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
    StandarError error = new StandarError(System.currentTimeMillis(),status.value(),"não encontrado!", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(error);
    }
}
