package pro.skyjava.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.servise.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {


    private final JavaQuestionService service;

    JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }

        @GetMapping("/add")
    Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping
    Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping("/test")
    Collection<Question> getTestQuestions() {
        service.addTestQuestions();
        return service.getAll();
    }


    @GetMapping("/remove")
    Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }
}
