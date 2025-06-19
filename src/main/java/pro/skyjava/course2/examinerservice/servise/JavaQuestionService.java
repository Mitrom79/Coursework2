package pro.skyjava.course2.examinerservice.servise;

import org.springframework.stereotype.Service;
import pro.skyjava.course2.examinerservice.domain.Question;

import java.util.*;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (!questions.contains(q)) {
            questions.add(q);
        }
        return q;
    }

    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        }
        return question;
    }

    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
        }
        return question;
    }

    public Collection<Question> getAll() {
        Collection<Question> res = questions;
        return res;
    }

    public Question getRandomQuestion() {
        Question res = new Question("Видите этот вопрос?", "Значит преподаватель не успел подготовить вопросы");
        if (!questions.isEmpty()) {
            int i = new Random().nextInt(questions.size());
            Iterator<Question> iterator = questions.iterator();
            for (; i >= 0; i--) {
                res = iterator.next();
            }
        }
        return res;
    }

    public String getAnswer(String question) {

        Question q = new Question("пустой вопрос", "ответа нет");
        String res = q.getAnswer();
        Iterator<Question> iterator = questions.iterator();
        while (iterator.hasNext()) {
            q = iterator.next();
            if (q.getQuestion().equals(question)) {
                res = q.getAnswer();
            }
        }
        return res;
    }

    public void addTestQuestions() {
        add("Что такое Объектно-ориентированное программирование (ООП) в Java?", "Парадигма программирования, основанная на концепции \"объектов\", которые инкапсулируют данные и методы для работы с этими данными. Java полностью следует этой парадигме.");
        add("Что такое Инкапсуляция в Java?", "Скрытие внутренней реализации объекта и предоставление доступа к нему только через определенные интерфейсы. Это обеспечивает защиту данных и упрощает поддержку кода.");
        add("Что такое Наследование в Java?", "Механизм, позволяющий создавать новые классы (подклассы) на основе существующих (суперклассов), наследуя их свойства и методы и добавляя новые.");
        add("Что такое Полиморфизм в Java?", "Способность объектов разных классов реагировать на один и тот же метод по-разному, в зависимости от их конкретного типа.");
        add("Что такое Абстракция в Java?", "Отображение только существенных характеристик объекта, скрывая детали реализации.");
        add("Что такое Виртуальная машина Java (JVM)?", "Программное обеспечение, которое выполняет байт-код Java, транслированный из исходного кода. JVM обеспечивает платформенную независимость Java, поскольку она реализована для различных операционных систем.");
        add("Что такое Java Development Kit (JDK)?", "Пакет инструментов, необходимых для разработки приложений на Java, включая компилятор, библиотеки и инструменты отладки.");
        add("Что такое Байт-код?", "Промежуточный язык, генерируемый компилятором Java, который затем выполняется JVM.");
        add("Что такое Метод?", "Блок кода, который выполняет определенную задачу и может принимать аргументы и возвращать значения.");
        add("Что такое Класс?", "Шаблон или чертеж для создания объектов. Классы содержат поля (данные) и методы (действия).");
    }
}