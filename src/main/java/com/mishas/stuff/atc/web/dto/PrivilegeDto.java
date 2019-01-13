package com.mishas.stuff.atc.web.dto;

import com.mishas.stuff.atc.persistence.model.Privilege;
import com.mishas.stuff.common.web.INameableDto;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PrivilegeDto implements INameableDto {

    private Long id;
    @NotNull
    private String name;

    private String description;

    // Constructor

    public PrivilegeDto() {
        super();
    }

    public PrivilegeDto(@NotNull String name) {
        super();
        this.name = name;
    }

    public PrivilegeDto(@NotNull String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public PrivilegeDto(Privilege resource) {
        super();
        this.id = resource.getId();
        this.name = resource.getName();
        this.description = resource.getDescription();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //

    @Override
    public String toString() {
        return "PrivilegeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrivilegeDto)) return false;
        PrivilegeDto that = (PrivilegeDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription());
    }
}
