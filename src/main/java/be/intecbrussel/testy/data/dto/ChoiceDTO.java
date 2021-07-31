package be.intecbrussel.testy.data.dto;

import be.intecbrussel.testy.data.EntityMapper;
import be.intecbrussel.testy.data.entity.ChoiceEntity;

import java.util.Arrays;
import java.util.Objects;

public class ChoiceDTO implements java.io.Serializable, EntityMapper<ChoiceEntity> {

    public ChoiceDTO() {
    }

    public ChoiceDTO(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChoiceDTO withId(Long id) {
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

    public ChoiceDTO withWeight(Double weight){
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

    public ChoiceDTO withHeader(String header) {
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

    public ChoiceDTO withBody(String body) {
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

    public ChoiceDTO withImage(Byte[] image) {
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

    public ChoiceDTO withDocument(Byte[] document) {
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

    public ChoiceDTO withExplanation(String explanation) {
        setExplanation(explanation);
        return this;
    }

    private QuestionDTO question;

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public ChoiceDTO withQuestion(QuestionDTO question) {
        setQuestion(question);
        return this;
    }

    public boolean isNew() {
        return Objects.isNull(this.id);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChoiceDTO)) return false;
        ChoiceDTO choiceDTO = (ChoiceDTO) o;
        return Objects.equals(getHeader(), choiceDTO.getHeader()) && Objects.equals(getQuestion(), choiceDTO.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeader(), getQuestion());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ChoiceDTO{");
        sb.append("id=").append(id);
        sb.append(", weight=").append(weight);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", image=").append(image == null ? "null" : Arrays.asList(image).toString());
        sb.append(", document=").append(document == null ? "null" : Arrays.asList(document).toString());
        sb.append(", explanation='").append(explanation).append('\'');
        sb.append(", questionId=").append(question.getId());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public ChoiceEntity toEntity() {
        final var entity = new ChoiceEntity()
                .withId(Objects.requireNonNull(this.getId()))
                .withWeight(Objects.requireNonNull(this.getWeight()))
                .withHeader(Objects.requireNonNull(this.getHeader()))
                .withBody(Objects.requireNonNull(this.getBody()))
                .withImage(Objects.requireNonNull(this.getImage()))
                .withDocument(Objects.requireNonNull(this.getDocument()))
                .withExplanation(Objects.requireNonNull(this.getExplanation()))
                .withQuestion(Objects.requireNonNull(this.getQuestion().toEntity()));

        return entity;
    }
}