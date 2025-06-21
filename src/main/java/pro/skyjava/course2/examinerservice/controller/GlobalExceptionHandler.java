package pro.skyjava.course2.examinerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = {ExamController.class})
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> notEnoughQuestions(IllegalArgumentException e) {
        if (e.getMessage().contains("В хранилище недостаточно вопросов")) {
            return ResponseEntity.badRequest().body("В хранилище недостаточно вопросов");
        } else {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
