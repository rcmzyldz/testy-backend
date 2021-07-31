package be.intecbrussel.testy.data.dto;

import java.time.Instant;
import java.util.Objects;


public class ExamDTO implements java.io.Serializable {

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
        return Objects.isNull(this.id);
    }
}
