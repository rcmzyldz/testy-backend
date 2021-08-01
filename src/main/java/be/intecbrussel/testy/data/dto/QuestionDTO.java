package be.intecbrussel.testy.data.dto;

import be.intecbrussel.testy.data.EntityMapper;
import be.intecbrussel.testy.data.entity.QuestionEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class QuestionDTO implements java.io.Serializable, EntityMapper<QuestionEntity> {

    public QuestionDTO() {
    }

    public QuestionDTO(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionDTO withId(Long id) {
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

    public QuestionDTO withHeader(String header) {
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

    public QuestionDTO withBody(String body) {
        setBody(body);
        return this;
    }

    private final Set<ChoiceDTO> choices = new HashSet<>();

    public void addChoice(ChoiceDTO choice) {
        choice.setQuestion(this);
        this.choices.add(choice);
    }

    public void removeChoice(ChoiceDTO choice) {
        choice.setQuestion(null);
        this.choices.remove(choice);
    }

    public void removeChoice(Long choiceId) {
        this.choices.removeIf(choice -> Objects.requireNonNull(choice.getId()).equals(choiceId));
    }

    public Set<ChoiceDTO> getChoices() {
        return choices;
    }

    private AnswerDTO answer;

    public AnswerDTO getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDTO answer) {
        this.answer = answer;
    }

    public QuestionDTO withAnswer(AnswerDTO answer) {
        setAnswer(answer);
        return this;
    }

    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionDTO)) return false;
        QuestionDTO that = (QuestionDTO) o;
        return Objects.equals(getHeader(), that.getHeader()) && Objects.equals(getBody(), that.getBody()) && getChoices().containsAll(that.getChoices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeader(), getBody(), getChoices());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionDTO{");
        sb.append("id=").append(id);
        sb.append(", header='").append(header).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", choices=").append(choices);
        sb.append(", answerId=").append(answer.getId());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public QuestionEntity toEntity() {

        final var entity = new QuestionEntity();
        entity.setId(this.getId());
        entity.setHeader(this.getHeader());
        entity.setBody(this.getBody());
        entity.setAnswer(this.getAnswer().toEntity());

        for (ChoiceDTO choice : getChoices()) {
            entity.addChoice(choice.toEntity());
        }

        return entity;
    }
}