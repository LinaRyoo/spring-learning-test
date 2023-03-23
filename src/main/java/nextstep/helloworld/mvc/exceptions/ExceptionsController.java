package nextstep.helloworld.mvc.exceptions;

import nextstep.helloworld.mvc.exceptions.exception.CustomException;
import nextstep.helloworld.mvc.exceptions.exception.HelloException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/exceptions")
public class ExceptionsController {

    @GetMapping("/hello")
    public ResponseEntity exceptionHandler() {
        throw new CustomException();
    }

    @GetMapping("/hi")
    public ResponseEntity exceptionHandler2() {
        throw new HelloException();
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handle() {
        return ResponseEntity.badRequest().body("CustomException");
    }

    @ExceptionHandler(HelloException.class)
    public ResponseEntity<String> handle2() {
        return ResponseEntity.badRequest().body("HelloException");
    }
}