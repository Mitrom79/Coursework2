package pro.skyjava.course2.examinerservice.servise;

import pro.skyjava.course2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionService {

    String getAnswer(String question);

    Collection<Question> getAll();
}
