package be.intecbrussel.testy.data.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


// JPA
@Entity(name = "exam")

public class ExamEntity extends AuditableEntity<String> implements java.io.Serializable {

    @Id
    @GeneratedValue
    private
    long id;

    @NotNull
    private
    String code;

    @NotNull
    private
    String header;

    @Lob
    private
    String body;

    @Transient
    private
    Timestamp started;

    @Transient
    private
    Timestamp ended;

    @JoinTable(name = "exam_students",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "USER_ENTITY_ID"))
    @ManyToMany
    private final Set<UserEntity> students = new HashSet<>();

    public ExamEntity() {
    }

    public void addStudent(UserEntity user) {
        this.students.add(user);
    }

    public void removeStudent(UserEntity user) {
        this.students.remove(user);
    }

    public void removeStudent(long studentId) {
        this.students.removeIf(student -> student.getId() == studentId);
    }

    @OneToMany(mappedBy = "exam")
    private final Set<QuestionEntity> questions = new HashSet<>();

    public void addQuestion(QuestionEntity question){
        this.questions.add(question);
    }

    public void removeQuestion(QuestionEntity question){
        this.questions.remove(question);
    }

    public void removeQuestion(long questionId){
        this.questions.removeIf(question -> question.getId() == questionId);
    }

    public long getId() {
        return this.id;
    }

    public @NotNull String getCode() {
        return this.code;
    }

    public @NotNull String getHeader() {
        return this.header;
    }

    public String getBody() {
        return this.body;
    }

    public Timestamp getStarted() {
        return this.started;
    }

    public Timestamp getEnded() {
        return this.ended;
    }

    public Set<UserEntity> getStudents() {
        return this.students;
    }

    public Set<QuestionEntity> getQuestions() {
        return this.questions;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCode(@NotNull String code) {
        this.code = code;
    }

    public void setHeader(@NotNull String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setStarted(Timestamp started) {
        this.started = started;
    }

    public void setEnded(Timestamp ended) {
        this.ended = ended;
    }

    public String toString() {
        return "ExamEntity(id=" + this.getId() + ", code=" + this.getCode() + ", header=" + this.getHeader() + ", body=" + this.getBody() + ", started=" + this.getStarted() + ", ended=" + this.getEnded() + ", students=" + this.getStudents() + ", questions=" + this.getQuestions() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ExamEntity)) return false;
        final ExamEntity other = (ExamEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ExamEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }
}
