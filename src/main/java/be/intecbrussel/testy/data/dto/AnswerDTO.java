package be.intecbrussel.testy.data.dto;


import java.io.Serializable;

// LOMBOK

public class AnswerDTO implements Serializable {

    private Long id;

    private String header;

    private String body;

    private byte[] document;

    public AnswerDTO(Long id, String header, String body, byte[] document) {
        this.id = id;
        this.header = header;
        this.body = body;
        this.document = document;
    }

    public AnswerDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getHeader() {
        return this.header;
    }

    public String getBody() {
        return this.body;
    }

    public byte[] getDocument() {
        return this.document;
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

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public String toString() {
        return "AnswerDTO(id=" + this.getId() + ", header=" + this.getHeader() + ", body=" + this.getBody() + ", document=" + java.util.Arrays.toString(this.getDocument()) + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AnswerDTO)) return false;
        final AnswerDTO other = (AnswerDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AnswerDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }
}
