package be.intecbrussel.testy.data.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// LOMBOK

// JPA
@Entity(name = "question")

public class QuestionEntity extends AuditableEntity<String> implements java.io.Serializable  {

    @Id
    @GeneratedValue
    private
    long id;

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

    public void removeChoice(long choiceId){
        this.choices.removeIf(choice -> choice.getId() == choiceId);
    }

    @OneToOne
    @JoinColumn
    private
    AnswerEntity answer;

    @ManyToOne
    private
    ExamEntity exam;

    public long getId() {
        return this.id;
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

    public void setId(long id) {
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuestionEntity)) return false;
        final QuestionEntity other = (QuestionEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }
}