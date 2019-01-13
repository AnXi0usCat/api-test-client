package com.mishas.stuff.atc.web.dto;

import com.mishas.stuff.atc.persistence.model.Role;
import com.mishas.stuff.atc.persistence.model.User;
import com.mishas.stuff.common.web.INameableDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

public class UserDto implements INameableDto {


    private Long id;
    @NotNull
    private String name;
    @Email
    private String email;
    @NotNull
    private String password;

    private Set<Role> roles;

    // Constructor

    public UserDto() {
        super();
    }

    public UserDto(@NotNull String name, @Email String email, @NotNull String password, Set<Role> roles) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserDto(User resource) {
        super();
        this.id = resource.getId();
        this.name = resource.getName();
        this.email = resource.getEmail();
        this.password = resource.getPassword();
        this.roles = resource.getRoles();
    }

    // API

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    //

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(getId(), userDto.getId()) &&
                Objects.equals(getName(), userDto.getName()) &&
                Objects.equals(getEmail(), userDto.getEmail()) &&
                Objects.equals(getPassword(), userDto.getPassword()) &&
                Objects.equals(getRoles(), userDto.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPassword(), getRoles());
    }
}
