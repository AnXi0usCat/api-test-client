package com.mishas.stuff.atc.web.dto;

import com.mishas.stuff.atc.persistence.model.Privilege;
import com.mishas.stuff.atc.persistence.model.Role;
import com.mishas.stuff.common.web.INameableDto;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

public class RoleDto implements INameableDto {

    private Long id;
    @NotNull
    private String name;

    private Set<Privilege> privileges;

    // Constructor

    public RoleDto() {
        super();
    }

    public RoleDto(@NotNull String name, Set<Privilege> privileges) {
        super();
        this.name = name;
        this.privileges = privileges;
    }

    public RoleDto(Role resource) {
        this.id = resource.getId();
        this.name = resource.getName();
        this.privileges = resource.getPrivileges();
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

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    //

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", privileges=" + privileges +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDto)) return false;
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(getId(), roleDto.getId()) &&
                Objects.equals(getName(), roleDto.getName()) &&
                Objects.equals(getPrivileges(), roleDto.getPrivileges());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrivileges());
    }
}
