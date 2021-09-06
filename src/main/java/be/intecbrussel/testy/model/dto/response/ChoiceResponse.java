package be.intecbrussel.testy.model.dto.response;

import be.intecbrussel.testy.model.EntityMapper;
import be.intecbrussel.testy.model.entity.ChoiceEntity;
import be.intecbrussel.testy.model.entity.QuestionEntity;

import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChoiceResponse implements java.io.Serializable, EntityMapper<ChoiceEntity> {

    public ChoiceResponse() {
    }

    public ChoiceResponse(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChoiceResponse withId(Long id) {
        setId(id);
        return this;
    }

    private Double weight;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public ChoiceResponse withWeight(Double weight) {
        setWeight(weight);
        return this;
    }

    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ChoiceResponse withHeader(String header) {
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

    public ChoiceResponse withBody(String body) {
        setBody(body);
        return this;
    }

    private Byte[] image;

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public ChoiceResponse withImage(Byte[] image) {
        setImage(image);
        return this;
    }

    private Byte[] document;

    public Byte[] getDocument() {
        return document;
    }

    public void setDocument(Byte[] document) {
        this.document = document;
    }

    public ChoiceResponse withDocument(Byte[] document) {
        setDocument(document);
        return this;
    }

    private String explanation;

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public ChoiceResponse withExplanation(String explanation) {
        setExplanation(explanation);
        return this;
    }

    private Long questionId;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public ChoiceResponse withQuestion(Long question) {
        setQuestionId(question);
        return this;
    }

    public boolean isNew() {
        return Objects.isNull(this.id);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChoiceResponse)) return false;
        ChoiceResponse choiceDTO = (ChoiceResponse) o;
        return Objects.equals(getHeader(), choiceDTO.getHeader()) && Objects.equals(getQuestionId(), choiceDTO.getQuestionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeader(), getQuestionId());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ChoiceResponse{");
        sb.append("id=").append(id);
        sb.append(", weight=").append(weight);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", image=").append(image == null ? "null" : Arrays.asList(image).toString());
        sb.append(", document=").append(document == null ? "null" : Arrays.asList(document).toString());
        sb.append(", explanation='").append(explanation).append('\'');
        sb.append(", questionId=").append(getQuestionId());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public ChoiceEntity toEntity() {
        final var entity = new ChoiceEntity();
        if (this.id != null)
            entity.setId(this.getId());
        if (this.weight != null)
            entity.setWeight(this.getWeight());
        if (this.header != null)
            entity.setHeader(this.getHeader());
        if (this.body != null)
            entity.setBody(this.getBody());
        if (this.image != null)
            entity.setImage(this.getImage());
        if (this.document != null)
            entity.setDocument(this.getDocument());
        if (this.explanation != null)
            entity.setExplanation(this.getExplanation());
        if (this.questionId != null)
            entity.setQuestion(new QuestionEntity(this.getQuestionId()));

        return entity;
    }
}