package pro.skyjava.course2.examinerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.servise.JavaQuestionService;

import java.util.Collection;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void add_withCorrectQuestion_whenAddedQuestion() {
        Question q = new Question("Test?", "Test!");

        javaQuestionService.add(q);
        Question actRes = javaQuestionService.getRandomQuestion();
        Assertions.assertEquals(actRes, q);
        Assertions.assertEquals(1, javaQuestionService.getAll().size());
    }

    @Test
    void add_withRepeatQuestion_whenNothingAdded() {
        Question q = new Question("Test?", "Test!");
        javaQuestionService.add(q);
        javaQuestionService.add(q);
        Collection<Question> actRes = javaQuestionService.getAll();
        Assertions.assertEquals(1, javaQuestionService.getAll().size());
    }

    @Test
    void remove_withCorrectQuestion_whenRemoveQuestion() {
        Question q = new Question("Test?", "Test!");
        Question q2 = new Question("2Test?", "2Test!");
        javaQuestionService.add(q);
        javaQuestionService.add(q2);
        javaQuestionService.remove(q2);
        Question actRes = javaQuestionService.getRandomQuestion();
        Assertions.assertEquals(actRes, q);
        Assertions.assertEquals(1, javaQuestionService.getAll().size());
    }


    @Test
    void remove_withWrongQuestion_whenNothingHappens() {
        Question q = new Question("Test?", "Test!");
        Question q2 = new Question("2Test?", "2Test!");
        javaQuestionService.add(q);
        javaQuestionService.remove(q2);
        Question actRes = javaQuestionService.getRandomQuestion();
        Assertions.assertEquals(actRes, q);
        Assertions.assertEquals(1, javaQuestionService.getAll().size());
    }

    @Test
    void getRandomQuestion_withEmptyCollection_whenDefaultQuestions() {
        Question q = javaQuestionService.getRandomQuestion();
        Assertions.assertEquals("Видите этот вопрос?", q.getQuestion());
        Assertions.assertEquals("Значит преподаватель не успел подготовить вопросы", q.getAnswer());
    }

    @Test
    void getAnswer_withValidQuestion_whenValidAnswer() {
        Question q = new Question("Test?", "Test!");
        Question q2 = new Question("2Test?", "2Test!");
        javaQuestionService.add(q);
        javaQuestionService.add(q2);
        String actRes = javaQuestionService.getAnswer("Test?");
        Assertions.assertEquals("Test!", actRes);
    }

    @Test
    void getAnswer_withInvalidQuestion_whenDefaulAnswer() {
        Question q = new Question("Test?", "Test!");
        javaQuestionService.add(q);
        String actRes = javaQuestionService.getAnswer("2Test");
        Assertions.assertEquals("Ответа нет :(", actRes);
    }

}