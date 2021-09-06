package be.intecbrussel.testy.model.dto.response;

import be.intecbrussel.testy.model.EntityMapper;
import be.intecbrussel.testy.model.entity.AnswerEntity;
import be.intecbrussel.testy.model.entity.QuestionEntity;

import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerResponse implements java.io.Serializable, EntityMapper<AnswerEntity> {

    public AnswerResponse() {
    }

    public AnswerResponse(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnswerResponse withId(Long id) {
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

    public AnswerResponse withHeader(String header) {
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

    public AnswerResponse withBody(String body) {
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

    public AnswerResponse withDocument(String document) {
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

    public AnswerResponse withQuestionId(Long question) {
        setQuestionId(question);
        return this;
    }

    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerResponse)) return false;
        AnswerResponse answerDTO = (AnswerResponse) o;
        return Objects.equals(getHeader(), answerDTO.getHeader()) && Objects.equals(getBody(), answerDTO.getBody()) && Objects.equals(getQuestionId(), answerDTO.getQuestionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeader(), getBody(), getQuestionId());
    }

    @Override
    public String toString() {
        final var sb = new StringBuffer("AnswerResponse{");
        sb.append("id=").append(id);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", document=").append(document == null ? "null" : Arrays.asList(document).toString());
        sb.append(", questionId=").append(questionId);
        sb.append('}');
        return sb.toString();
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