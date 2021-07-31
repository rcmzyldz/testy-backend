package be.intecbrussel.testy.data.dto;

import be.intecbrussel.testy.data.EntityMapper;
import be.intecbrussel.testy.data.entity.AnswerEntity;

import java.util.Arrays;
import java.util.Objects;

public class AnswerDTO implements java.io.Serializable, EntityMapper<AnswerEntity> {

    public AnswerDTO() {
    }

    public AnswerDTO(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnswerDTO withId(Long id) {
        setId(id);
        return this;
    }

    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public AnswerDTO withHeader(String header) {
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

    public AnswerDTO withBody(String body) {
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

    public AnswerDTO withDocument(Byte[] document) {
        setDocument(document);
        return this;
    }

    private QuestionDTO question;

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public AnswerDTO withQuestion(QuestionDTO question) {
        setQuestion(question);
        return this;
    }

    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerDTO)) return false;
        AnswerDTO answerDTO = (AnswerDTO) o;
        return Objects.equals(getHeader(), answerDTO.getHeader()) && Objects.equals(getBody(), answerDTO.getBody()) && Objects.equals(getQuestion().getId(), answerDTO.getQuestion().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeader(), getBody(), getQuestion());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AnswerDTO{");
        sb.append("id=").append(id);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", document=").append(document == null ? "null" : Arrays.asList(document).toString());
        sb.append(", questionId=").append(question.getId());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public AnswerEntity toEntity() {
        final var entity = new AnswerEntity()
                .withId(Objects.requireNonNull(this.getId()))
                .withHeader(Objects.requireNonNull(this.getHeader()))
                .withBody(Objects.requireNonNull(this.getBody()))
                .withDocument(Objects.requireNonNull(this.getDocument()))
                .withQuestion(Objects.requireNonNull(this.getQuestion().toEntity()));

        return entity;
    }
}