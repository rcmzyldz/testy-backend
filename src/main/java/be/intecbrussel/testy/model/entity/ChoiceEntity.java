package be.intecbrussel.testy.model.entity;

import be.intecbrussel.testy.model.DTOMapper;
import be.intecbrussel.testy.model.dto.ChoiceDTO;
import be.intecbrussel.testy.model.dto.create.CreateChoiceRequest;
import be.intecbrussel.testy.model.dto.response.ChoiceResponse;
import be.intecbrussel.testy.model.dto.search.SearchChoiceRequest;
import be.intecbrussel.testy.model.dto.update.UpdateChoiceRequest;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


@Entity
public class ChoiceEntity implements java.io.Serializable, Persistable<Long>, 
                            DTOMapper<CreateChoiceRequest, UpdateChoiceRequest, SearchChoiceRequest, ChoiceResponse> {

    public ChoiceEntity() {
    }

    public ChoiceEntity(Long id) {
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

    public ChoiceEntity withId(Long id) {
        setId(id);
        return this;
    }

    @PositiveOrZero
    private Double weight;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public ChoiceEntity withWeight(Double weight) {
        setWeight(weight);
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

    public ChoiceEntity withHeader(String header) {
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

    public ChoiceEntity withBody(String body) {
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

    public ChoiceEntity withImage(Byte[] image) {
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

    public ChoiceEntity withDocument(Byte[] document) {
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

    public ChoiceEntity withExplanation(String explanation) {
        setExplanation(explanation);
        return this;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    private QuestionEntity question;

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public ChoiceEntity withQuestion(QuestionEntity question) {
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
        if (!(o instanceof ChoiceEntity)) return false;
        ChoiceEntity that = (ChoiceEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        final var sb = new StringBuffer("ChoiceEntity{");
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
    public CreateChoiceRequest toCreate() {
        final var dto = new CreateChoiceRequest();
        if (this.id != null)
            dto.setId(this.getId());
        if (this.weight != null)
            dto.setWeight(this.getWeight());
        if (this.header != null)
            dto.setHeader(this.getHeader());
        if (this.body != null)
            dto.setBody(this.getBody());
        if (this.image != null)
            dto.setImage(this.getImage());
        if (this.document != null)
            dto.setDocument(this.getDocument());
        if (this.explanation != null)
            dto.setExplanation(this.getExplanation());
        if (this.question != null)
            dto.setQuestionId(this.getQuestion().toCreate().getId());

        return dto;
    }

    @Override
    public UpdateChoiceRequest toUpdate() {

        final var dto = new UpdateChoiceRequest();
        if (this.id != null)
            dto.setId(this.getId());
        if (this.weight != null)
            dto.setWeight(this.getWeight());
        if (this.header != null)
            dto.setHeader(this.getHeader());
        if (this.body != null)
            dto.setBody(this.getBody());
        if (this.image != null)
            dto.setImage(this.getImage());
        if (this.document != null)
            dto.setDocument(this.getDocument());
        if (this.explanation != null)
            dto.setExplanation(this.getExplanation());
        if (this.question != null)
            dto.setQuestionId(this.getQuestion().toUpdate().getId());

        return dto;
    }

    @Override
    public SearchChoiceRequest toSearch() {
        final var dto = new SearchChoiceRequest();
        if (this.id != null)
            dto.setId(this.getId());
        if (this.weight != null)
            dto.setWeight(this.getWeight());
        if (this.header != null)
            dto.setHeader(this.getHeader());
        if (this.body != null)
            dto.setBody(this.getBody());
        if (this.image != null)
            dto.setImage(this.getImage());
        if (this.document != null)
            dto.setDocument(this.getDocument());
        if (this.explanation != null)
            dto.setExplanation(this.getExplanation());
        if (this.question != null)
            dto.setQuestionId(this.getQuestion().toSearch().getId());

        return dto;
    }

    @Override
    public ChoiceResponse toResponse() {
        final var dto = new ChoiceResponse();
        if (this.id != null)
            dto.setId(this.getId());
        if (this.weight != null)
            dto.setWeight(this.getWeight());
        if (this.header != null)
            dto.setHeader(this.getHeader());
        if (this.body != null)
            dto.setBody(this.getBody());
        if (this.image != null)
            dto.setImage(this.getImage());
        if (this.document != null)
            dto.setDocument(this.getDocument());
        if (this.explanation != null)
            dto.setExplanation(this.getExplanation());
        if (this.question != null)
            dto.setQuestionId(this.getQuestion().toResponse().getId());

        return dto;
    }
}