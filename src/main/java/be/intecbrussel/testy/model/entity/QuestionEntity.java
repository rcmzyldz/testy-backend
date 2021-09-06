package be.intecbrussel.testy.model.entity;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.domain.Persistable;

import be.intecbrussel.testy.model.DTOMapper;
import be.intecbrussel.testy.model.dto.create.CreateQuestionRequest;
import be.intecbrussel.testy.model.dto.response.QuestionResponse;
import be.intecbrussel.testy.model.dto.search.SearchQuestionRequest;
import be.intecbrussel.testy.model.dto.update.UpdateQuestionRequest;

@Entity
public class QuestionEntity implements java.io.Serializable, Persistable<Long>,
                                 DTOMapper<CreateQuestionRequest, UpdateQuestionRequest, SearchQuestionRequest, QuestionResponse> {

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
        choice.setQuestion(this);
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

    @OneToOne(
            mappedBy = "question",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private AnswerEntity answer;

    public AnswerEntity getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerEntity answer) {
        answer.setQuestion(this);
        this.answer = answer;
    }

    public QuestionEntity withAnswer(AnswerEntity answer) {
        setAnswer(answer);
        return this;
    }

    @OneToMany(mappedBy = "question")
    private final Set<ExamEntity> exams = new LinkedHashSet<>();

    public Set<ExamEntity> getExams() {
        return exams;
    }

    public void addExam(ExamEntity exam) {
        exam.setQuestion(this);
        this.exams.add(exam);
    }

    public QuestionEntity withExam(ExamEntity exam) {
        addExam(exam);
        return this;
    }

    public void removeExam(ExamEntity exam) {
        exam.setQuestion(null);
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
        final var sb = new StringBuffer("QuestionEntity{");
        sb.append("id=").append(id);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", choices=").append(choices);
        sb.append(", answer=").append(answer);
        sb.append(", exams=").append(exams);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public CreateQuestionRequest toCreate() {
        final var dto = new CreateQuestionRequest();

        if (this.id != null)
            dto.setId(this.getId());

        if (this.header != null)
            dto.setHeader(this.getHeader());

        if (this.body != null)
            dto.setBody(this.getBody());

        if (this.answer != null)
            dto.setAnswer(this.getAnswer().toCreate());

        if (!this.choices.isEmpty())
            for (ChoiceEntity choice : getChoices()) {
                if (choice != null)
                    dto.addChoice(choice.toCreate().getId());
            }

        return dto;
    }

    @Override
    public UpdateQuestionRequest toUpdate() {
        final var dto = new UpdateQuestionRequest();

        if (this.id != null)
            dto.setId(this.getId());

        if (this.header != null)
            dto.setHeader(this.getHeader());

        if (this.body != null)
            dto.setBody(this.getBody());

        if (this.answer != null)
            dto.setAnswer(this.getAnswer().toUpdate());

        if (!this.choices.isEmpty())
            for (ChoiceEntity choice : getChoices()) {
                if (choice != null)
                    dto.addChoice(choice.toUpdate().getId());
            }

        return dto;
    }

    @Override
    public SearchQuestionRequest toSearch() {
        final var dto = new SearchQuestionRequest();

        if (this.id != null)
            dto.setId(this.getId());

        if (this.header != null)
            dto.setHeader(this.getHeader());

        if (this.body != null)
            dto.setBody(this.getBody());

        if (this.answer != null)
            dto.setAnswer(this.getAnswer().toSearch());

        if (!this.choices.isEmpty())
            for (ChoiceEntity choice : getChoices()) {
                if (choice != null)
                    dto.addChoice(choice.toSearch().getId());
            }

        return dto;
    }

    @Override
    public QuestionResponse toResponse() {
        final var dto = new QuestionResponse();

        if (this.id != null)
            dto.setId(this.getId());

        if (this.header != null)
            dto.setHeader(this.getHeader());

        if (this.body != null)
            dto.setBody(this.getBody());

        if (this.answer != null)
            dto.setAnswer(this.getAnswer().toResponse());

        if (!this.choices.isEmpty())
            for (ChoiceEntity choice : getChoices()) {
                if (choice != null)
                    dto.addChoice(choice.toResponse().getId());
            }

        return dto;
    }
}