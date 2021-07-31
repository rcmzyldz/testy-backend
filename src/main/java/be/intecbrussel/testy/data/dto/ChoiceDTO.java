package be.intecbrussel.testy.data.dto;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

public class ChoiceDTO implements java.io.Serializable {

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

    public ChoiceDTO with(Double weight){
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


}