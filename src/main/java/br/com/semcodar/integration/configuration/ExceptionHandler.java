package br.com.semcodar.integration.configuration;

import br.com.semcodar.integration.configuration.exception.Error;
import br.com.semcodar.integration.configuration.exception.InternalServerError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
@Controller
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> badRequest(final IllegalArgumentException exception) {
        return new ResponseEntity<Error>(new Error(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InternalServerError.class)
    public ResponseEntity<Error> handleInternalServerErrorException(final IllegalArgumentException exception) {
        return new ResponseEntity<Error>(new Error(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
