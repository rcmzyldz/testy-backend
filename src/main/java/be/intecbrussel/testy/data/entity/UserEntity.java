package be.intecbrussel.testy.data.entity;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

// LOMBOK

// JPA
@Entity(name = "user")

public class UserEntity implements java.io.Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    private
    Long id;

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

    @OneToMany(mappedBy = "student")
    private final Set<ExamEntity> exams = new HashSet<>();

    private Double score;

    public UserEntity() {
    }

    public void addExam(ExamEntity exam){
        this.exams.add(exam);
    }

    public void removeExam(ExamEntity exam){
        this.exams.remove(exam);
    }

    public void removeExam(Long examId){
        this.exams.removeIf(exam -> exam.getId() == examId);
    }

    @URL
    @NotEmpty
    private
    String profile = "https://www.testy-exams.com/user/anonymous";

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(this.id);
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

    public void setId(Long id) {
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

    protected boolean canEqual(final Object other) {
        return other instanceof UserEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
