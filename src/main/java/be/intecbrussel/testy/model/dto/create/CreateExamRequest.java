package be.intecbrussel.testy.model.dto.create;

import be.intecbrussel.testy.model.EntityMapper;
import be.intecbrussel.testy.model.entity.ExamEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.Objects;

import static java.util.Objects.hash;
import static java.util.Objects.isNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateExamRequest implements java.io.Serializable, EntityMapper<ExamEntity> {

    public CreateExamRequest() {
    }

    public CreateExamRequest(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreateExamRequest withId(Long id) {
        setId(id);
        return this;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CreateExamRequest withCode(String code) {
        setCode(code);
        return this;
    }

    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public CreateExamRequest withHeader(String header) {
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

    public CreateExamRequest withBody(String body) {
        setBody(body);
        return this;
    }

    private CreateQuestionRequest question;

    public CreateQuestionRequest getQuestion() {
        return question;
    }

    public void setQuestion(CreateQuestionRequest question) {
        this.question = question;
    }

    public CreateExamRequest withQuestion(CreateQuestionRequest question) {
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

    public CreateExamRequest withStarted(Instant started) {
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

    public CreateExamRequest withEnded(Instant ended) {
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

    public CreateExamRequest withScore(Double score) {
        setScore(score);
        return this;
    }

    public boolean isNew() {
        return isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateExamRequest)) return false;
        CreateExamRequest createExamRequest = (CreateExamRequest) o;
        return Objects.equals(getCode(), createExamRequest.getCode()) && Objects.equals(getQuestion(), createExamRequest.getQuestion());
    }

    @Override
    public int hashCode() {
        return hash(getCode(), getQuestion());
    }

    @Override
    public String toString() {
        return "CreateExamRequest{" + "id=" + id +
                ", code='" + code + '\'' +
                ", header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", questionId=" + question.getId() +
                ", started=" + started +
                ", ended=" + ended +
                ", score=" + score +
                '}';
    }

    @Override
    public ExamEntity toEntity() {
        final var entity = new ExamEntity();

        if (this.id != null)
            entity.setId(this.getId());

        if (this.code != null)
            entity.setCode(this.getCode());

        if (this.header != null)
            entity.setHeader(this.getHeader());

        if (this.body != null)
            entity.setBody(this.getBody());

        if (this.question != null)
            entity.setQuestion(this.getQuestion().toEntity());

        if (this.started != null)
            entity.setStarted(this.getStarted());

        if (this.ended != null)
            entity.setEnded(this.getEnded());

        if (this.score != null)
            entity.setScore(this.getScore());

        return entity;
    }
}
