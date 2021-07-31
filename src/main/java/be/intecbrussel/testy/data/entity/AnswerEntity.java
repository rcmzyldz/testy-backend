package be.intecbrussel.testy.data.entity;

import be.intecbrussel.testy.data.DTOMapper;
import be.intecbrussel.testy.data.dto.AnswerDTO;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

// JPA
@Entity(name = "answer")

public class AnswerEntity implements java.io.Serializable, Persistable<Long>, DTOMapper<AnswerDTO> {

    public AnswerEntity() {
    }

    public AnswerEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnswerEntity withId(Long id) {
        setId(id);
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

    public AnswerEntity withHeader(String header) {
        setHeader(header);
        return this;
    }

    @NotNull
    @Lob
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AnswerEntity withBody(String body) {
        setBody(body);
        return this;
    }

    private Byte[] document;

    public Byte[] getDocument() {
        return document;
    }

    public void setDocument(Byte[] document) {
        this.document = document;
    }

    public AnswerEntity withDocument(Byte[] document) {
        setDocument(document);
        return this;
    }

    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private QuestionEntity question;

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public AnswerEntity withQuestion(QuestionEntity question) {
        setQuestion(question);
        return this;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(this.id);
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AnswerEntity{");
        sb.append("id=").append(id);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", document=").append(document == null ? "null" : Arrays.asList(document).toString());
        sb.append(", questionId=").append(question.getId());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public AnswerDTO toDTO() {
        final var dto = new AnswerDTO()
                .withId(Objects.requireNonNull(this.getId()))
                .withHeader(Objects.requireNonNull(this.getHeader()))
                .withBody(Objects.requireNonNull(this.getBody()))
                .withDocument(Objects.requireNonNull(this.getDocument()))
                .withQuestion(Objects.requireNonNull(this.getQuestion().toDTO()));

        return dto;
    }
}