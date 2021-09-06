package be.intecbrussel.testy.model.dto.update;

import be.intecbrussel.testy.model.DTOMapper;
import be.intecbrussel.testy.model.EntityMapper;
import be.intecbrussel.testy.model.entity.AnswerEntity;
import be.intecbrussel.testy.model.dto.update.*;

import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateAnswerRequest implements java.io.Serializable, EntityMapper<AnswerEntity> {

    public UpdateAnswerRequest() {
    }

    public UpdateAnswerRequest(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UpdateAnswerRequest withId(Long id) {
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

    public UpdateAnswerRequest withHeader(String header) {
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

    public UpdateAnswerRequest withBody(String body) {
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

    public UpdateAnswerRequest withDocument(String document) {
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

    public UpdateAnswerRequest withQuestionId(Long question) {
        setQuestionId(question);
        return this;
    }

    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UpdateAnswerRequest))
            return false;
        UpdateAnswerRequest answerDTO = (UpdateAnswerRequest) o;
        return Objects.equals(getHeader(), answerDTO.getHeader()) && Objects.equals(getBody(), answerDTO.getBody())
                && Objects.equals(getQuestionId(), answerDTO.getQuestionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeader(), getBody(), getQuestionId());
    }

    @Override
    public String toString() {
        final var sb = new StringBuffer("UpdateAnswerRequest{");
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
            entity.setQuestion(new QuestionDTO(this.getQuestionId()).toEntity());

        return entity;
    }


}