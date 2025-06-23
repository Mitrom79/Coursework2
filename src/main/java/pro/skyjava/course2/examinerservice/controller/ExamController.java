package pro.skyjava.course2.examinerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.servise.ExaminerServiceImpl;



import java.util.Collection;


@RestController
public class ExamController {
    private final ExaminerServiceImpl examinerServiceIml;

    ExamController(ExaminerServiceImpl examinerServiceIml) {
        this.examinerServiceIml = examinerServiceIml;
    }



    @GetMapping("/exam/get/")
    Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerServiceIml.getQuestions(amount);
    }
}
