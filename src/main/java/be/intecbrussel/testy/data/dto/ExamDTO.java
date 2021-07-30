package be.intecbrussel.testy.data.dto;


import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

// LOMBOK

public class ExamDTO implements Serializable {

    private Long id;

    private String code;

    private String header;

    private String body;

    private Instant started;

    private Instant ended;

    private final Set<QuestionDTO> questions = new HashSet<>();

    public ExamDTO(Long id, String code, String header, String body, Instant started, Instant ended) {
        this.id = id;
        this.code = code;
        this.header = header;
        this.body = body;
        this.started = started;
        this.ended = ended;
    }

    public ExamDTO() {
    }

    public void addQuestion(QuestionDTO question){
        this.questions.add(question);
    }

    public void removeQuestion(QuestionDTO question){
        this.questions.remove(question);
    }

    public void removeQuestion(Long questionId){
        this.questions.removeIf(question -> question.getId() == questionId);
    }

    public Long getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getHeader() {
        return this.header;
    }

    public String getBody() {
        return this.body;
    }

    public Instant getStarted() {
        return this.started;
    }

    public Instant getEnded() {
        return this.ended;
    }

    public Set<QuestionDTO> getQuestions() {
        return this.questions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setStarted(Instant started) {
        this.started = started;
    }

    public void setEnded(Instant ended) {
        this.ended = ended;
    }

    public String toString() {
        return "ExamDTO(id=" + this.getId() + ", code=" + this.getCode() + ", header=" + this.getHeader() + ", body=" + this.getBody() + ", started=" + this.getStarted() + ", ended=" + this.getEnded() + ", questions=" + this.getQuestions() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ExamDTO)) return false;
        final ExamDTO other = (ExamDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ExamDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }
}
