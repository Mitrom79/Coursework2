package pro.skyjava.course2.examinerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.servise.ExaminerServiceImpl;
import pro.skyjava.course2.examinerservice.servise.JavaQuestionService;

import java.util.Collection;
import java.util.Collections;

import java.util.Set;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService mockJavaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl testExaminerServiceImpl;

    @Test
    void getQuestions_withAmountGivesOutOneAndSizeCollectionOne_whenGetOneQuestion() {
        Question q = new Question("Test?", "Test!");
        when(mockJavaQuestionService.getAll()).thenReturn(Set.of(q));
        when(mockJavaQuestionService.getRandomQuestion()).thenReturn(q);
        Collection<Question> actRes = testExaminerServiceImpl.getQuestions(1);
        Assertions.assertEquals(1, actRes.size());
    }

    @Test
    void getQuestions_withAmountGreaterThanSizeCollection_whenThrowsIllegalArgumentException() {
        when(mockJavaQuestionService.getAll()).thenReturn(Collections.emptySet());
        Assertions.assertThrows(IllegalArgumentException.class, () -> testExaminerServiceImpl.getQuestions(5));
    }
}
