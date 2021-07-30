package be.intecbrussel.testy.data.entity;


import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


// JPA
@Entity(name = "exam")

public class ExamEntity implements java.io.Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private
    String code;

    @NotNull
    private
    String header;

    @Lob
    private
    String body;

    private Instant started;

    private Instant ended;

    @JoinTable(name = "exam_students",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
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

    public void removeStudent(Long studentId) {
        this.students.removeIf(student -> student.getId() == studentId);
    }

    @OneToMany(mappedBy = "exam")
    private final Set<QuestionEntity> questions = new HashSet<>();

    public void addQuestion(QuestionEntity question) {
        this.questions.add(question);
    }

    public void removeQuestion(QuestionEntity question) {
        this.questions.remove(question);
    }

    public void removeQuestion(Long questionId) {
        this.questions.removeIf(question -> question.getId() == questionId);
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(this.id);
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

    public Instant getStarted() {
        return this.started;
    }

    public Instant getEnded() {
        return this.ended;
    }

    public Set<UserEntity> getStudents() {
        return this.students;
    }

    public Set<QuestionEntity> getQuestions() {
        return this.questions;
    }

    public void setId(Long id) {
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

    public void setStarted(Instant started) {
        this.started = started;
    }

    public void setEnded(Instant ended) {
        this.ended = ended;
    }

    public String toString() {
        return "ExamEntity(id=" + this.getId() + ", code=" + this.getCode() + ", header=" + this.getHeader() + ", body=" + this.getBody() + ", started=" + this.getStarted() + ", ended=" + this.getEnded() + ", students=" + this.getStudents() + ", questions=" + this.getQuestions() + ")";
    }


    protected boolean canEqual(final Object other) {
        return other instanceof ExamEntity;
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
}
