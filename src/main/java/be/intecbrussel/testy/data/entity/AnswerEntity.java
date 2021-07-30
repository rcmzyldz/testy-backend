package be.intecbrussel.testy.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// JPA
@Entity(name = "answer")

public class AnswerEntity extends AuditableEntity<String> implements java.io.Serializable {

    @Id
    @GeneratedValue
    private
    long id;

    @NotNull
    private
    String header;

    @NotNull
    @Lob
    private
    String body;

    private byte[] document;

    @OneToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
    private
    QuestionEntity question;

    public AnswerEntity() {
    }

    public long getId() {
        return this.id;
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

    public void setId(long id) {
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AnswerEntity)) return false;
        final AnswerEntity other = (AnswerEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AnswerEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }
}