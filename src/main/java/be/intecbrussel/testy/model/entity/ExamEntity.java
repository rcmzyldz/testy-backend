package be.intecbrussel.testy.model.entity;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Persistable;

import be.intecbrussel.testy.model.DTOMapper;
import be.intecbrussel.testy.model.dto.create.CreateExamRequest;
import be.intecbrussel.testy.model.dto.response.ExamResponse;
import be.intecbrussel.testy.model.dto.search.SearchExamRequest;
import be.intecbrussel.testy.model.dto.update.UpdateExamRequest;

@Entity
public class ExamEntity implements java.io.Serializable, Persistable<Long>, 
                            DTOMapper<CreateExamRequest, UpdateExamRequest, SearchExamRequest, ExamResponse> {

    public ExamEntity() {
    }

    public ExamEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamEntity withId(Long id) {
        setId(id);
        return this;
    }

    @NotNull
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ExamEntity withCode(String code) {
        setCode(code);
        return this;
    }

    @NotNull
    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ExamEntity withHeader(String header) {
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

    public ExamEntity withBody(String body) {
        setBody(body);
        return this;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private UserEntity student;

    public UserEntity getStudent() {
        return student;
    }

    public void setStudent(UserEntity student) {
        this.student = student;
    }

    public ExamEntity withStudent(UserEntity student) {
        setStudent(student);
        return this;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public ExamEntity withQuestion(QuestionEntity question) {
        setQuestion(question);
        return this;
    }

    private Instant started;

    public Instant getStarted() {
        return started;
    }

    public void setStarted(Instant started) {
        this.started = started;
    }

    public ExamEntity withStarted(Instant started) {
        setStarted(started);
        return this;
    }

    private Instant ended;

    public Instant getEnded() {
        return ended;
    }

    public void setEnded(Instant ended) {
        this.ended = ended;
    }

    public ExamEntity withEnded(Instant ended) {
        setEnded(ended);
        return this;
    }

    private Double score;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public ExamEntity withScore(Double score) {
        setScore(score);
        return this;
    }

    private boolean isActivated;

    public boolean getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public ExamEntity withIsActivated(boolean isActivated) {
        setIsActivated(isActivated);
        return this;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamEntity)) return false;
        ExamEntity that = (ExamEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        final var sb = new StringBuffer("ExamEntity{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", studentId=").append(student.getId());
        sb.append(", questionId=").append(question.getId());
        sb.append(", started=").append(started);
        sb.append(", ended=").append(ended);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public CreateExamRequest toCreate() {
        final var dto = new CreateExamRequest();
        dto.setId(this.getId());
        dto.setCode(this.getCode());
        dto.setHeader(this.getHeader());
        dto.setBody(this.getBody());
        dto.setStudent(this.getStudent().toCreate());
        dto.setQuestion(this.getQuestion().toCreate());
        dto.setStarted(this.getStarted());
        dto.setEnded(this.getEnded());
        dto.setScore(this.getScore());

        return dto;
    }

    @Override
    public UpdateExamRequest toUpdate() {
        final var dto = new UpdateExamRequest();
      
        dto.setId(this.getId());
        dto.setCode(this.getCode());
        dto.setHeader(this.getHeader());
        dto.setBody(this.getBody());
        dto.setStudent(this.getStudent().toUpdate());
        dto.setQuestion(this.getQuestion().toUpdate());
        dto.setStarted(this.getStarted());
        dto.setEnded(this.getEnded());
        dto.setScore(this.getScore());

        return dto;
    }

    public UpdateExamRequest toUpdate(final String code, final String header, final String body) {
        final var dto = new UpdateExamRequest();

        dto.setId(this.getId());
        dto.setCode(code);
        dto.setHeader(header);
        dto.setBody(body);
        dto.setStudent(this.getStudent().toUpdate());
        dto.setQuestion(this.getQuestion().toUpdate());
        dto.setStarted(this.getStarted());
        dto.setEnded(this.getEnded());
        dto.setScore(this.getScore());

        return dto;
    }

    @Override
    public SearchExamRequest toSearch() {
        final var dto = new SearchExamRequest();
        dto.setId(this.getId());
        dto.setCode(this.getCode());
        dto.setHeader(this.getHeader());
        dto.setBody(this.getBody());
        dto.setStudent(this.getStudent().toSearch());
        dto.setQuestion(this.getQuestion().toSearch());
        dto.setStarted(this.getStarted());
        dto.setEnded(this.getEnded());
        dto.setScore(this.getScore());

        return dto;
    }

    @Override
    public ExamResponse toResponse() {
        final var dto = new ExamResponse();
        dto.setId(this.getId());
        dto.setCode(this.getCode());
        dto.setHeader(this.getHeader());
        dto.setBody(this.getBody());
        dto.setStudent(this.getStudent().toResponse());
        dto.setQuestion(this.getQuestion().toResponse());
        dto.setStarted(this.getStarted());
        dto.setEnded(this.getEnded());
        dto.setScore(this.getScore());

        return dto;
    }

}
