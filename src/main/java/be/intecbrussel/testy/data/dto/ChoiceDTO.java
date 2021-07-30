package be.intecbrussel.testy.data.dto;


import java.io.Serializable;

// LOMBOK

public class ChoiceDTO implements Serializable {

    // JACKSON
    private long id;

    private double weight;

    private String header;

    private String body;

    private String image;

    private String explanation;

    public ChoiceDTO(long id, double weight, String header, String body, String image, String explanation) {
        this.id = id;
        this.weight = weight;
        this.header = header;
        this.body = body;
        this.image = image;
        this.explanation = explanation;
    }

    public ChoiceDTO() {
    }

    public long getId() {
        return this.id;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getHeader() {
        return this.header;
    }

    public String getBody() {
        return this.body;
    }

    public String getImage() {
        return this.image;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String toString() {
        return "ChoiceDTO(id=" + this.getId() + ", weight=" + this.getWeight() + ", header=" + this.getHeader() + ", body=" + this.getBody() + ", image=" + this.getImage() + ", explanation=" + this.getExplanation() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ChoiceDTO)) return false;
        final ChoiceDTO other = (ChoiceDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ChoiceDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }
}
