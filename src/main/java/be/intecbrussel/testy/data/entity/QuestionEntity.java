package be.intecbrussel.testy.data.entity;


import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// LOMBOK

// JPA
@Entity(name = "question")

public class QuestionEntity implements java.io.Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    private
    Long id;

    private String header;

    @Lob
    private
    String body;

    @OneToMany(mappedBy = "question", cascade = { CascadeType.ALL })
    private final Set<ChoiceEntity> choices = new HashSet<>();

    public QuestionEntity() {
    }

    public void addChoice(ChoiceEntity choice){
        this.choices.add(choice);
    }

    public void removeChoice(ChoiceEntity choice){
        this.choices.remove(choice);
    }

    public void removeChoice(Long choiceId){
        this.choices.removeIf(choice -> choice.getId() == choiceId);
    }

    @OneToOne
    @JoinColumn
    private
    AnswerEntity answer;

    @ManyToOne
    private
    ExamEntity exam;

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    public String getHeader() {
        return this.header;
    }

    public String getBody() {
        return this.body;
    }

    public Set<ChoiceEntity> getChoices() {
        return this.choices;
    }

    public AnswerEntity getAnswer() {
        return this.answer;
    }

    public ExamEntity getExam() {
        return this.exam;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAnswer(AnswerEntity answer) {
        this.answer = answer;
    }

    public void setExam(ExamEntity exam) {
        this.exam = exam;
    }

    public String toString() {
        return "QuestionEntity(id=" + this.getId() + ", header=" + this.getHeader() + ", body=" + this.getBody() + ", choices=" + this.getChoices() + ", answer=" + this.getAnswer() + ", exam=" + this.getExam() + ")";
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionEntity)) return false;
        QuestionEntity that = (QuestionEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}