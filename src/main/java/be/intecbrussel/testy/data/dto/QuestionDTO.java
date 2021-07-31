package be.intecbrussel.testy.data.dto;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


public class QuestionDTO implements java.io.Serializable {

    public QuestionDTO() {
    }

    public QuestionDTO(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionDTO withId(Long id) {
        setId(id);
        return this;
    }

    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public QuestionDTO withHeader(String header) {
        setHeader(header);
        return this;
    }

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public QuestionDTO withBody(String body) {
        setBody(body);
        return this;
    }

    private final Set<ChoiceDTO> choices = new HashSet<>();

    public void addChoice(ChoiceDTO choice) {
        this.choices.add(choice);
    }

    public void removeChoice(ChoiceDTO choice) {
        this.choices.remove(choice);
    }

    public void removeChoice(Long choiceId) {
        this.choices.removeIf(choice -> Objects.requireNonNull(choice.getId()).equals(choiceId));
    }

    public Set<ChoiceDTO> getChoices() {
        return choices;
    }

    private AnswerDTO answer;

    public AnswerDTO getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDTO answer) {
        this.answer = answer;
    }

    public QuestionDTO withAnswer(AnswerDTO answer) {
        setAnswer(answer);
        return this;
    }

    private final Set<ExamDTO> exams = new LinkedHashSet<>();

    public void addExam(ExamDTO exam) {
        this.exams.add(exam);
    }

    public QuestionDTO withExam(ExamDTO exam) {
        addExam(exam);
        return this;
    }

    public void removeExam(ExamDTO exam) {
        this.exams.remove(exam);
    }

    public void removeExam(Long examId) {
        this.exams.removeIf(exam -> Objects.equals(exam.getId(), examId));
    }

    public QuestionDTO withoutExam(ExamDTO exam) {
        removeExam(exam);
        return this;
    }

    public QuestionDTO withoutExam(Long examId) {
        removeExam(examId);
        return this;
    }

    public boolean isNew() {
        return Objects.isNull(this.id);
    }

}