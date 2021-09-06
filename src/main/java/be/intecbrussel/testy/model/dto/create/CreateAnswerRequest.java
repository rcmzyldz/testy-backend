package be.intecbrussel.testy.model.dto.create;

import be.intecbrussel.testy.model.EntityMapper;
import be.intecbrussel.testy.model.entity.AnswerEntity;
import be.intecbrussel.testy.model.entity.QuestionEntity;

import java.util.List;
import java.util.Objects;

public class CreateAnswerRequest implements java.io.Serializable, EntityMapper<AnswerEntity> {

    // TODO: remove id, is_new and all other unnecessary fields while creating.

    public CreateAnswerRequest() {
    }

    public CreateAnswerRequest(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreateAnswerRequest withId(Long id) {
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

    public CreateAnswerRequest withHeader(String header) {
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

    public CreateAnswerRequest withBody(String body) {
        setBody(body);
        return this;
    }

    private String document;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public CreateAnswerRequest withDocument(String document) {
        setDocument(document);
        return this;
    }

    private Long questionId;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public CreateAnswerRequest withQuestionId(Long question) {
        setQuestionId(question);
        return this;
    }

    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateAnswerRequest)) return false;
        CreateAnswerRequest createAnswerRequest = (CreateAnswerRequest) o;
        return Objects.equals(getHeader(), createAnswerRequest.getHeader()) && Objects.equals(getBody(), createAnswerRequest.getBody()) && Objects.equals(getQuestionId(), createAnswerRequest.getQuestionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeader(), getBody(), getQuestionId());
    }

    @Override
    public String toString() {
        return "{" + "id=" + id +
                ", header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", document=" + (document == null ? "null" : List.of(document).toString()) +
                ", questionId=" + questionId +
                '}';
    }

    @Override
    public AnswerEntity toEntity() {
        final var entity = new AnswerEntity();

        if (this.id != null)
            entity.setId(this.getId());

        if (this.header != null)
            entity.setHeader(this.getHeader());

        if (this.body != null)
            entity.setBody(this.getBody());

        if (this.document != null)
            entity.setDocument(this.getDocument());

        if (this.questionId != null)
            entity.setQuestion(new QuestionEntity(this.getQuestionId()));

        return entity;
    }
}