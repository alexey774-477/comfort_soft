package testDemo.application.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    private static final org.apache.logging.log4j.Logger log
            = org.apache.logging.log4j.LogManager.getLogger(ApplicationExceptionHandler.class);

    @ExceptionHandler(testDemo.application.exepction.ApplicationException.class)
    protected ResponseEntity<Object> handleEntityApplicationException(testDemo.application.exepction.ApplicationException ex, WebRequest request) {

        log.error("{}: \n{}", request.getRemoteUser(), ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
