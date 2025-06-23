package pro.skyjava.course2.examinerservice.servise;

import org.springframework.stereotype.Service;
import pro.skyjava.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;



import java.util.*;


@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    public Collection<Question> getQuestions(int amount) {

        if (amount > javaQuestionService.getAll().size())
            throw new IllegalArgumentException("В хранилище недостаточно вопросов");
        Collection<Question> res = new HashSet<>();
        Question q;
        while (res.size() != amount) {
            q = javaQuestionService.getRandomQuestion();
            if (!res.contains(q)) {
                res.add(q);
            }
        }
        return res;
    }



}
