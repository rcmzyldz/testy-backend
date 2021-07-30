package be.intecbrussel.testy.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

// LOMBOK

public class UserDTO implements Serializable {
    
        // JACKSON
        private long id;

        private String firstName;

        private String lastName;

        private String email;

        private String phone;

        private String password;

        private String roles;

        private String session;

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        private
        String activation;

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        private
        boolean activated;

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        private
        boolean authenticated;

        private String profile;

    public UserDTO() {
    }

    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRoles() {
        return this.roles;
    }

    public String getSession() {
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

    public String getProfile() {
        return this.profile;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setActivation(String activation) {
        this.activation = activation;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String toString() {
        return "UserDTO(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ", password=" + this.getPassword() + ", roles=" + this.getRoles() + ", session=" + this.getSession() + ", activation=" + this.getActivation() + ", activated=" + this.isActivated() + ", authenticated=" + this.isAuthenticated() + ", profile=" + this.getProfile() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDTO)) return false;
        final UserDTO other = (UserDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }
}
