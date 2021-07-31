package be.intecbrussel.testy.data.dto;

import java.util.Objects;

public class AnswerDTO implements java.io.Serializable{

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


}