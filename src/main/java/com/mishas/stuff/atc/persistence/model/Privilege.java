package com.mishas.stuff.atc.persistence.model;

import com.mishas.stuff.atc.web.dto.PrivilegeDto;
import com.mishas.stuff.common.persistence.INameableEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Privilege implements INameableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRIV_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = false, nullable = true)
    private String description;

    public Privilege() {
        super();
    }

    public Privilege(String name) {
        super();
        this.name = name;
    }

    public Privilege(PrivilegeDto resource) {
        this.id = resource.getId();
        this.name = resource.getName();
        this.description = resource.getDescription();
    }

    // API

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Privilege)) return false;
        Privilege privilege = (Privilege) o;
        return Objects.equals(getId(), privilege.getId()) &&
                Objects.equals(getName(), privilege.getName()) &&
                Objects.equals(getDescription(), privilege.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription());
    }
}
