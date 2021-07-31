package be.intecbrussel.testy.data.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;


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

    @ManyToOne
    @JoinColumn(name = "student_id")
    private UserEntity student;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    private Instant started;

    private Instant ended;

    public ExamEntity() {
    }

    public ExamEntity(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExamEntity{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", student=").append(student);
        sb.append(", started=").append(started);
        sb.append(", ended=").append(ended);
        sb.append('}');
        return sb.toString();
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
