package be.intecbrussel.testy.data.dto;

import be.intecbrussel.testy.data.EntityMapper;
import be.intecbrussel.testy.data.entity.ExamEntity;

import java.time.Instant;
import java.util.Objects;

import static java.util.Objects.*;


public class ExamDTO implements java.io.Serializable, EntityMapper<ExamEntity> {

    public ExamDTO() {
    }

    public ExamDTO(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamDTO withId(Long id) {
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

    public ExamDTO withCode(String code) {
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

    public ExamDTO withHeader(String header) {
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

    public ExamDTO withBody(String body) {
        setBody(body);
        return this;
    }

    private UserDTO student;

    public UserDTO getStudent() {
        return student;
    }

    public void setStudent(UserDTO student) {
        this.student = student;
    }

    public ExamDTO withStudent(UserDTO student) {
        setStudent(student);
        return this;
    }

    private QuestionDTO question;

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public ExamDTO withQuestion(QuestionDTO question) {
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

    public ExamDTO withStarted(Instant started) {
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

    public ExamDTO withEnded(Instant ended) {
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

    public ExamDTO withScore(Double score) {
        setScore(score);
        return this;
    }

    public boolean isNew() {
        return isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamDTO)) return false;
        ExamDTO examDTO = (ExamDTO) o;
        return Objects.equals(getCode(), examDTO.getCode()) && Objects.equals(getStudent(), examDTO.getStudent()) && Objects.equals(getQuestion(), examDTO.getQuestion());
    }

    @Override
    public int hashCode() {
        return hash(getCode(), getStudent(), getQuestion());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExamDTO{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", studentId=").append(student.getId());
        sb.append(", questionId=").append(question.getId());
        sb.append(", started=").append(started);
        sb.append(", ended=").append(ended);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
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

        if (this.student != null)
            entity.setStudent(this.getStudent().toEntity());

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
