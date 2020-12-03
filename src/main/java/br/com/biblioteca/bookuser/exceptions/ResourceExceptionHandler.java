package br.com.biblioteca.bookuser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {
    private static final String METHOD_ARGUMENT_NOT_VALIDATE = "Validation Error";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> objectNotfound(Exception e, HttpServletRequest request) {
        StandardError err = new StandardError(
                String.valueOf(LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.toString(), e.getMessage(), String.valueOf(request.getRequestURL())
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

//    @ExceptionHandler(QuestionNotFoundException.class)
//    public ResponseEntity<StandardError> objectNotfound(QuestionNotFoundException e, HttpServletRequest request) {
//        StandardError err = new StandardError(
//                String.valueOf(LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
//                HttpStatus.NOT_FOUND.toString(), e.getMessage(), String.valueOf(request.getRequestURL())
//        );
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
//    }
//
//    @ExceptionHandler(AlternativeNotFoundException.class)
//    public ResponseEntity<StandardError> objectNotfound(AlternativeNotFoundException e, HttpServletRequest request) {
//        StandardError err = new StandardError(
//                String.valueOf(LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
//                HttpStatus.NOT_FOUND.toString(), e.getMessage(), String.valueOf(request.getRequestURL())
//        );
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
//    }
//
//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<StandardError> objectNotfound(UserNotFoundException e, HttpServletRequest request) {
//        StandardError err = new StandardError(
//                String.valueOf(LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
//                HttpStatus.NOT_FOUND.toString(), e.getMessage(), String.valueOf(request.getRequestURL())
//        );
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
//    }
//
//    @ExceptionHandler(QuestionFlowBreakException.class)
//    public ResponseEntity<StandardError> questionFlowBreak(QuestionFlowBreakException e, HttpServletRequest request) {
//        StandardError err = new StandardError(
//                String.valueOf(LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
//                HttpStatus.NOT_FOUND.toString(), e.getMessage(), String.valueOf(request.getRequestURL())
//        );
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
//    }
//
//    @ExceptionHandler(QuestionnaireIsPublishedTrueException.class)
//    public ResponseEntity<StandardError> questionnaireIsPublishedTrue(QuestionnaireIsPublishedTrueException e, HttpServletRequest request) {
//        StandardError err = new StandardError(
//                String.valueOf(LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
//                HttpStatus.NOT_FOUND.toString(), e.getMessage(), String.valueOf(request.getRequestURL())
//        );
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<StandardError> methodArgumentNotValid(HttpServletRequest request) {
//        StandardError err = new StandardError(
//                String.valueOf(LocalDateTime.now()), HttpStatus.BAD_REQUEST.value(),
//                HttpStatus.BAD_REQUEST.toString(), METHOD_ARGUMENT_NOT_VALIDATE, String.valueOf(request.getRequestURL())
//        );
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//    }
}
