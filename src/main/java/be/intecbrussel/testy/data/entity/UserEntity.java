package be.intecbrussel.testy.data.entity;

import be.intecbrussel.testy.data.DTOMapper;
import be.intecbrussel.testy.data.dto.UserDTO;
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

@Entity
public class UserEntity implements java.io.Serializable, Persistable<Long>, DTOMapper<UserDTO> {

    public UserEntity() {
    }

    public UserEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity withId(Long id) {
        setId(id);
        return this;
    }

    @NotEmpty
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserEntity withFirstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    @NotEmpty
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserEntity withLastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity withEmail(String email) {
        setEmail(email);
        return this;
    }

    // @Phone // TODO: activate on production..
    @NotEmpty
    @Column(unique = true)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserEntity withPhone(String phone) {
        setPhone(phone);
        return this;
    }

    // @ValidPassword // TODO: activate on production..
    @NotEmpty
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity withPassword(String password) {
        setPassword(password);
        return this;
    }

    // @ValidRole
    @NotEmpty
    private String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        if (Objects.isNull(roles)) {
            roles = "ROLE_ANONYMOUS";
        }
        this.roles = roles;
    }

    public UserEntity withRoles(String roles) {
        setRoles(roles);
        return this;
    }

    @NotNull
    private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public UserEntity withSession(String session) {
        setSession(session);
        return this;
    }

    private String activation;

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        if (Objects.isNull(activation)) {
            activation = UUID.randomUUID().toString();
        }
        this.activation = activation;
    }

    public UserEntity withActivation(String activation) {
        setActivation(activation);
        return this;
    }

    private Boolean activated;

    public Boolean isActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public UserEntity withActivated(Boolean activated) {
        setActivated(activated);
        return this;
    }

    private Boolean authenticated;

    public Boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public UserEntity withAuthenticated(Boolean authenticated) {
        setAuthenticated(authenticated);
        return this;
    }

    @OneToMany(mappedBy = "student")
    private final Set<ExamEntity> exams = new HashSet<>();

    public void addExam(ExamEntity exam) {
        exam.setStudent(this);
        this.exams.add(exam);
    }

    public UserEntity withExam(ExamEntity exam) {
        addExam(exam);
        return this;
    }

    public void removeExam(ExamEntity exam) {
        exam.setQuestion(null);
        this.exams.remove(exam);
    }

    public UserEntity withoutExam(ExamEntity exam) {
        removeExam(exam);
        return this;
    }

    public void removeExam(Long examId) {
        this.exams.removeIf(exam -> Objects.equals(exam.getId(), examId));
    }

    public UserEntity withoutExam(Long examId) {
        removeExam(examId);
        return this;
    }

    public Set<ExamEntity> getExams() {
        return exams;
    }

    private Double score;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public UserEntity withScore(Double score) {
        setScore(score);
        return this;
    }

    @URL
    @NotEmpty
    private String profile;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        if (Objects.isNull(profile)) {
            profile = "https://www.testy-exams.com/user/anonymous";
        }
        this.profile = profile;
    }

    public UserEntity withProfile(String profile) {
        setProfile(profile);
        return this;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(this.id);
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

    @Override
    public String toString() {
        final var sb = new StringBuffer("UserEntity{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", roles='").append(roles).append('\'');
        sb.append(", session='").append(session).append('\'');
        sb.append(", activation='").append(activation).append('\'');
        sb.append(", activated=").append(activated);
        sb.append(", authenticated=").append(authenticated);
        sb.append(", exams=").append(exams);
        sb.append(", score=").append(score);
        sb.append(", profile='").append(profile).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public UserDTO toDTO() {

        final var dto = new UserDTO();

        if (this.id != null)
            dto.setId(this.getId());

        if (this.firstName != null)
            dto.setFirstName(this.getFirstName());

        if (this.lastName != null)
            dto.setLastName(this.getLastName());

        if (this.email != null)
            dto.setEmail(this.getEmail());

        if (this.phone != null)
            dto.setPhone(this.getPhone());

        if (this.password != null)
            dto.setPassword(this.getPassword());

        if (this.roles != null)
            dto.setRoles(this.getRoles());

        if (this.session != null)
            dto.setSession(this.getSession());

        if (this.activation != null)
            dto.setActivation(this.getActivation());

        if (this.activated != null)
            dto.setActivated(this.isActivated());

        if (this.authenticated != null)
            dto.setAuthenticated(this.isAuthenticated());

        if (this.score != null)
            dto.setScore(this.getScore());

        if (this.profile != null)
            dto.setProfile(this.getProfile());

        return dto;
    }
}
