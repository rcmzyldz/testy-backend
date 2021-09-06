package be.intecbrussel.testy.model.entity;

import be.intecbrussel.testy.model.DTOMapper;
import be.intecbrussel.testy.model.dto.AnswerDTO;
import be.intecbrussel.testy.model.dto.create.CreateAnswerRequest;
import be.intecbrussel.testy.model.dto.response.AnswerResponse;
import be.intecbrussel.testy.model.dto.search.SearchAnswerRequest;
import be.intecbrussel.testy.model.dto.update.UpdateAnswerRequest;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
public class AnswerEntity implements java.io.Serializable, Persistable<Long>, 
                                DTOMapper<CreateAnswerRequest, UpdateAnswerRequest, SearchAnswerRequest, AnswerResponse> {

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

    private String document;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public AnswerEntity withDocument(String document) {
        setDocument(document);
        return this;
    }

    @OneToOne
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
        final var sb = new StringBuffer("AnswerEntity{");
        sb.append("id=").append(id);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", document=").append(document == null ? "null" : List.of(document).toString());
        sb.append(", questionId=").append(question.getId());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public CreateAnswerRequest toCreate() {
        
        final var dto = new CreateAnswerRequest();

        if (this.id != null)
            dto.setId(this.getId());

        if (this.header != null)
            dto.setHeader(this.getHeader());

        if (this.body != null)
            dto.setBody(this.getBody());

        if (this.document != null)
            dto.setDocument(this.getDocument());

        if (this.question != null)
            dto.setQuestionId(this.getQuestion().toCreate().getId());

        return dto;

    }

    @Override
    public UpdateAnswerRequest toUpdate() {

        final var dto = new UpdateAnswerRequest();

        if (this.id != null)
            dto.setId(this.getId());

        if (this.header != null)
            dto.setHeader(this.getHeader());

        if (this.body != null)
            dto.setBody(this.getBody());

        if (this.document != null)
            dto.setDocument(this.getDocument());

        if (this.question != null)
            dto.setQuestionId(this.getQuestion().toUpdate().getId());

        return dto;
    }

    @Override
    public SearchAnswerRequest toSearch() {
        final var dto = new SearchAnswerRequest();

        if (this.id != null)
            dto.setId(this.getId());

        if (this.header != null)
            dto.setHeader(this.getHeader());

        if (this.body != null)
            dto.setBody(this.getBody());

        if (this.document != null)
            dto.setDocument(this.getDocument());

        if (this.question != null)
            dto.setQuestionId(this.getQuestion().toSearch().getId());

        return dto;
    }

    @Override
    public AnswerResponse toResponse() {
        final var dto = new AnswerResponse();

        if (this.id != null)
            dto.setId(this.getId());

        if (this.header != null)
            dto.setHeader(this.getHeader());

        if (this.body != null)
            dto.setBody(this.getBody());

        if (this.document != null)
            dto.setDocument(this.getDocument());

        if (this.question != null)
            dto.setQuestionId(this.getQuestion().toResponse().getId());

        return dto;
    }
}