package be.intecbrussel.testy.model.dto;

import be.intecbrussel.testy.model.EntityMapper;
import be.intecbrussel.testy.model.entity.ChoiceEntity;
import be.intecbrussel.testy.model.entity.QuestionEntity;

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

    private final Set<Long> choices = new HashSet<>();

    public void addChoice(Long choiceId) {
        this.choices.add(choiceId);
    }

    public void removeChoice(Long choiceId) {
        this.choices.remove(choiceId);
    }

    public Set<Long> getChoices() {
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

        if (this.id != null)
            entity.setId(this.getId());

        if (this.header != null)
            entity.setHeader(this.getHeader());

        if (this.body != null)
            entity.setBody(this.getBody());

        if (this.answer != null)
            entity.setAnswer(this.getAnswer().toEntity());

        if (!this.choices.isEmpty())
            for (Long choiceId : getChoices()) {
                if (choiceId != null)
                    entity.addChoice(new ChoiceEntity(choiceId));
            }

        return entity;
    }
}