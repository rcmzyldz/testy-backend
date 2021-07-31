package be.intecbrussel.testy.data.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;


// JPA
@Entity(name = "choice")

public class ChoiceEntity implements java.io.Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    private
    Long id;

    @PositiveOrZero
    private
    double weight;

    @NotNull
    private
    String header;

    @NotNull
    @Lob
    private
    String body;

    private String image;

    private String explanation;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private QuestionEntity question;

    public ChoiceEntity() {
    }

    public ChoiceEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    public @PositiveOrZero double getWeight() {
        return this.weight;
    }

    public @NotNull String getHeader() {
        return this.header;
    }

    public @NotNull String getBody() {
        return this.body;
    }

    public String getImage() {
        return this.image;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public QuestionEntity getQuestion() {
        return this.question;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWeight(@PositiveOrZero double weight) {
        this.weight = weight;
    }

    public void setHeader(@NotNull String header) {
        this.header = header;
    }

    public void setBody(@NotNull String body) {
        this.body = body;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public String toString() {
        return "ChoiceEntity(id=" + this.getId() + ", weight=" + this.getWeight() + ", header=" + this.getHeader() + ", body=" + this.getBody() + ", image=" + this.getImage() + ", explanation=" + this.getExplanation() + ", question=" + this.getQuestion() + ")";
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ChoiceEntity;
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
}