package com.mishas.stuff.atc.persistence.dao;

import com.mishas.stuff.atc.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
