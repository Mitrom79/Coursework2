package pro.skyjava.course2.examinerservice.servise;

import pro.skyjava.course2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    String getAnswer(String question);

    void addTestQuestions();




}
