package com.mishas.stuff.atc.persistence.model;

import com.mishas.stuff.atc.web.dto.RoleDto;
import com.mishas.stuff.common.persistence.INameableEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Role  implements INameableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "PRIV_ID", referencedColumnName = "PRIV_ID") })
    private Set<Privilege> privileges;

    // constructor

    public Role() {
        super();
    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role(String name, Set<Privilege> privileges) {
        super();
        this.name = name;
        this.privileges = privileges;
    }

    public Role(RoleDto resource) {
        super();
        this.id = resource.getId();
        this.name = resource.getName();
        this.privileges = resource.getPrivileges();
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

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    //

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", privileges=" + privileges +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId()) &&
                Objects.equals(getName(), role.getName()) &&
                Objects.equals(getPrivileges(), role.getPrivileges());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrivileges());
    }
}
