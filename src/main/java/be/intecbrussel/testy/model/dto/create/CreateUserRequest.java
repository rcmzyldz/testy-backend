package be.intecbrussel.testy.model.dto.create;

import be.intecbrussel.testy.model.EntityMapper;
import be.intecbrussel.testy.model.entity.UserEntity;

import java.util.Objects;
import java.util.UUID;

public class CreateUserRequest implements java.io.Serializable, EntityMapper<UserEntity> {

    public CreateUserRequest() {
    }

    public CreateUserRequest(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreateUserRequest withId(Long id) {
        setId(id);
        return this;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CreateUserRequest withFirstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CreateUserRequest withLastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreateUserRequest withEmail(String email) {
        setEmail(email);
        return this;
    }

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CreateUserRequest withPhone(String phone) {
        setPhone(phone);
        return this;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CreateUserRequest withPassword(String password) {
        setPassword(password);
        return this;
    }

    private String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public CreateUserRequest withRoles(String roles) {
        setRoles(roles);
        return this;
    }

    private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public CreateUserRequest withSession(String session) {
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

    public CreateUserRequest withActivation(String activation) {
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

    public CreateUserRequest withActivated(Boolean activated) {
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

    public CreateUserRequest withAuthenticated(Boolean authenticated) {
        setAuthenticated(authenticated);
        return this;
    }

    private Double score;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public CreateUserRequest withScore(Double score) {
        setScore(score);
        return this;
    }

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

    public CreateUserRequest withProfile(String profile) {
        setProfile(profile);
        return this;
    }

    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserRequest)) return false;
        CreateUserRequest createUserRequest = (CreateUserRequest) o;
        return Objects.equals(getEmail(), createUserRequest.getEmail()) && Objects.equals(getPhone(), createUserRequest.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPhone());
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", session='" + session + '\'' +
                ", activation='" + activation + '\'' +
                ", activated=" + activated +
                ", authenticated=" + authenticated +
                ", score=" + score +
                ", profile='" + profile + '\'' +
                '}';
    }

    @Override
    public UserEntity toEntity() {

        final var entity = new UserEntity();

        if (this.id != null)
            entity.setId(this.getId());

        if (this.firstName != null)
            entity.setFirstName(this.getFirstName());

        if (this.lastName != null)
            entity.setLastName(this.getLastName());

        if (this.email != null)
            entity.setEmail(this.getEmail());

        if (this.phone != null)
            entity.setPhone(this.getPhone());

        if (this.password != null)
            entity.setPassword(this.getPassword());

        if (this.roles != null)
            entity.setRoles(this.getRoles());

        if (this.session != null)
            entity.setSession(this.getSession());

        if (this.activation != null)
            entity.setActivation(this.getActivation());

        if (this.activated != null)
            entity.setActivated(this.isActivated());

        if (this.authenticated != null)
            entity.setAuthenticated(this.isAuthenticated());

        if (this.score != null)
            entity.setScore(this.getScore());

        if (this.profile != null)
            entity.setProfile(this.getProfile());

        return entity;
    }
}
