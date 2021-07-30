package be.intecbrussel.testy.config;

import be.intecbrussel.testy.data.entity.ChoiceEntity;
import be.intecbrussel.testy.data.entity.ExamEntity;
import be.intecbrussel.testy.data.entity.QuestionEntity;
import be.intecbrussel.testy.repository.ExamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

// LOMBOK

// SPRING
@Configuration

public class LoadDatabase {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(@Autowired ExamRepository repository, @Autowired ObjectMapper objectMapper) {

        return args -> {

            final int numberOfExams = 25;

            final var results = new LinkedList<ExamEntity>();

            // FOR(NO_OF_EXAMS)
            for (int examIndex = 1; examIndex <= numberOfExams; examIndex++) {

                ExamEntity exam = new ExamEntity();

                exam.setCode("EXAM_CODE_" + new Random().nextInt(1_000_000));
                exam.setHeader("Exam " + examIndex + " header");
                exam.setBody("Exam body for exam " + examIndex);
                exam.setStarted(Timestamp.from(Instant.now()));
                final var secondsToAdd = TimeUnit.HOURS.toSeconds(2);
                exam.setEnded(Timestamp.from(Instant.now().plusSeconds(secondsToAdd)));

                var numberOfQuestionsForEachExam = new Random().nextInt(100);
                if(numberOfQuestionsForEachExam < 1) numberOfQuestionsForEachExam = 10;

                // FOR(NO_OF_QUESTIONS)
                for (int questionIndex = 1; questionIndex <= numberOfQuestionsForEachExam; questionIndex++) {
                    final var question = new QuestionEntity();
                    question.setHeader("Question " + (examIndex * questionIndex) + " header.");
                    question.setBody("Question body " + (examIndex * questionIndex));

                    for (int choiceIndex = 1; choiceIndex <= 4; choiceIndex++) {
                        final var choice = new ChoiceEntity();
                        choice.setWeight(0);
                        choice.setHeader("Choice " + (examIndex * questionIndex * choiceIndex) + " header");
                        final var choiceResult = choice.getWeight() > 0.00 ? "Correct" : "Incorrect";
                        choice.setBody("Choice " + (examIndex * questionIndex * choiceIndex) + " body (" + choiceResult + ")");
                        choice.setExplanation("Choice explanation " + (examIndex * questionIndex * choiceIndex) + ".");
                        choice.setImage("https://picsum.photos/200");
                        question.addChoice(choice);
                    }

                    exam.addQuestion(question);
                }

                results.add(exam);
                repository.save(exam);
            }

            log.info("\n\n" + objectMapper.writeValueAsString(results) + "\n\n");
        };
    }

}