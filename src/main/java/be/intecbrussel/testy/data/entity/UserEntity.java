package be.intecbrussel.testy.data.entity;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

// LOMBOK

// JPA
@Entity(name = "user")

public class UserEntity extends AuditableEntity<String> implements java.io.Serializable  {

    @Id
    @GeneratedValue
    private
    long id;

    @NotEmpty
    private
    String firstName;

    @NotEmpty
    private
    String lastName;

    @NotEmpty
    @Email
    @Column(unique = true)
    private
    String email;

    @NotEmpty
    // @Phone // TODO: activate on production..
    @Column(unique = true)
    private
    String phone;

    @NotEmpty
    private
    // @ValidPassword // TODO: activate on production..
    String password;
    
    // @ValidRole
    @NotEmpty
    private
    String roles = "ROLE_ANONYMOUS";

    @NotNull
    private
    String session;

    private String activation = UUID.randomUUID().toString();

    private boolean activated = false;

    private boolean authenticated = false;

    @ManyToMany
    private final Set<ExamEntity> exams = new HashSet<>();

    public UserEntity() {
    }

    public void addExam(ExamEntity exam){
        this.exams.add(exam);
    }

    public void removeExam(ExamEntity exam){
        this.exams.remove(exam);
    }

    public void removeExam(long examId){
        this.exams.removeIf(exam -> exam.getId() == examId);
    }

    @URL
    @NotEmpty
    private
    String profile = "https://www.testy-exams.com/user/anonymous";

    public long getId() {
        return this.id;
    }

    public @NotEmpty String getFirstName() {
        return this.firstName;
    }

    public @NotEmpty String getLastName() {
        return this.lastName;
    }

    public @NotEmpty @Email String getEmail() {
        return this.email;
    }

    public @NotEmpty String getPhone() {
        return this.phone;
    }

    public @NotEmpty String getPassword() {
        return this.password;
    }

    public @NotEmpty String getRoles() {
        return this.roles;
    }

    public @NotNull String getSession() {
        return this.session;
    }

    public String getActivation() {
        return this.activation;
    }

    public boolean isActivated() {
        return this.activated;
    }

    public boolean isAuthenticated() {
        return this.authenticated;
    }

    public Set<ExamEntity> getExams() {
        return this.exams;
    }

    public @URL @NotEmpty String getProfile() {
        return this.profile;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(@NotEmpty String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotEmpty String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(@NotEmpty @Email String email) {
        this.email = email;
    }

    public void setPhone(@NotEmpty String phone) {
        this.phone = phone;
    }

    public void setPassword(@NotEmpty String password) {
        this.password = password;
    }

    public void setRoles(@NotEmpty String roles) {
        this.roles = roles;
    }

    public void setSession(@NotNull String session) {
        this.session = session;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public void setProfile(@URL @NotEmpty String profile) {
        this.profile = profile;
    }

    public String toString() {
        return "UserEntity(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ", password=" + this.getPassword() + ", roles=" + this.getRoles() + ", session=" + this.getSession() + ", activation=" + this.getActivation() + ", activated=" + this.isActivated() + ", authenticated=" + this.isAuthenticated() + ", exams=" + this.getExams() + ", profile=" + this.getProfile() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserEntity)) return false;
        final UserEntity other = (UserEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }
}
