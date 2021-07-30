package be.intecbrussel.testy.data.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

// JPA
@Entity(name = "answer")

public class AnswerEntity implements java.io.Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private
    String header;

    @NotNull
    @Lob
    private
    String body;

    private byte[] document;

    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private
    QuestionEntity question;

    public AnswerEntity() {
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    public @NotNull String getHeader() {
        return this.header;
    }

    public @NotNull String getBody() {
        return this.body;
    }

    public byte[] getDocument() {
        return this.document;
    }

    public QuestionEntity getQuestion() {
        return this.question;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeader(@NotNull String header) {
        this.header = header;
    }

    public void setBody(@NotNull String body) {
        this.body = body;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public String toString() {
        return "AnswerEntity(id=" + this.getId() + ", header=" + this.getHeader() + ", body=" + this.getBody() + ", document=" + java.util.Arrays.toString(this.getDocument()) + ", question=" + this.getQuestion() + ")";
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AnswerEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerEntity)) return false;
        AnswerEntity that = (AnswerEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}