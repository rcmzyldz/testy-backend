package be.intecbrussel.testy.data.entity;


import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

// LOMBOK

// JPA
@Entity(name = "question")

public class QuestionEntity implements java.io.Serializable, Persistable<Long> {

    public QuestionEntity() {
    }

    public QuestionEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionEntity withId(Long id) {
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

    public QuestionEntity withHeader(String header) {
        setHeader(header);
        return this;
    }

    @Lob
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public QuestionEntity withBody(String body) {
        setBody(body);
        return this;
    }

    @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL})
    private final Set<ChoiceEntity> choices = new HashSet<>();

    public void addChoice(ChoiceEntity choice) {
        this.choices.add(choice);
    }

    public void removeChoice(ChoiceEntity choice) {
        this.choices.remove(choice);
    }

    public void removeChoice(Long choiceId) {
        this.choices.removeIf(choice -> Objects.requireNonNull(choice.getId()).equals(choiceId));
    }

    public Set<ChoiceEntity> getChoices() {
        return choices;
    }

    @OneToOne
    @JoinColumn
    private AnswerEntity answer;

    public AnswerEntity getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerEntity answer) {
        this.answer = answer;
    }

    public QuestionEntity withAnswer(AnswerEntity answer) {
        setAnswer(answer);
        return this;
    }

    @OneToMany(mappedBy = "question")
    private final Set<ExamEntity> exams = new LinkedHashSet<>();

    public void addExam(ExamEntity exam) {
        this.exams.add(exam);
    }

    public QuestionEntity withExam(ExamEntity exam) {
        addExam(exam);
        return this;
    }

    public void removeExam(ExamEntity exam) {
        this.exams.remove(exam);
    }

    public void removeExam(Long examId) {
        this.exams.removeIf(exam -> Objects.equals(exam.getId(), examId));
    }

    public QuestionEntity withoutExam(ExamEntity exam) {
        removeExam(exam);
        return this;
    }

    public QuestionEntity withoutExam(Long examId) {
        removeExam(examId);
        return this;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionEntity)) return false;
        QuestionEntity that = (QuestionEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionEntity{");
        sb.append("id=").append(id);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", choices=").append(choices);
        sb.append(", answer=").append(answer);
        sb.append(", exams=").append(exams);
        sb.append('}');
        return sb.toString();
    }
}