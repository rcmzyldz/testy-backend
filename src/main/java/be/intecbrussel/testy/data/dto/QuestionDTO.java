package be.intecbrussel.testy.data.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// LOMBOK

public class QuestionDTO implements Serializable {

    // JACKSON
    private long id;

    private String header;

    private String body;

    private final Set<ChoiceDTO> choices = new HashSet<>();

    public QuestionDTO(long id, String header, String body) {
        this.id = id;
        this.header = header;
        this.body = body;
    }

    public QuestionDTO() {
    }

    public void addChoice(ChoiceDTO choice) {
        this.choices.add(choice);
    }

    public void removeChoice(ChoiceDTO choice) {
        this.choices.remove(choice);
    }

    public void removeChoice(long questionId) {
        this.choices.removeIf(choice -> choice.getId() == questionId);
    }

    public long getId() {
        return this.id;
    }

    public String getHeader() {
        return this.header;
    }

    public String getBody() {
        return this.body;
    }

    public Set<ChoiceDTO> getChoices() {
        return this.choices;
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

    public String toString() {
        return "QuestionDTO(id=" + this.getId() + ", header=" + this.getHeader() + ", body=" + this.getBody() + ", choices=" + this.getChoices() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuestionDTO)) return false;
        final QuestionDTO other = (QuestionDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }
}
