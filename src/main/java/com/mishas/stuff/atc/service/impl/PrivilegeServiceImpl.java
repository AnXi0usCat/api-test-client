package com.mishas.stuff.atc.service.impl;

import com.mishas.stuff.atc.persistence.dao.PrivilegeRepository;
import com.mishas.stuff.atc.persistence.model.Privilege;
import com.mishas.stuff.atc.service.PrivilegeService;
import com.mishas.stuff.atc.web.dto.PrivilegeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    public PrivilegeRepository privilegeRepository;

    @Override
    public PrivilegeDto get(Long id) {

        return new PrivilegeDto(privilegeRepository.getOne(id));
    }

    @Override
    public void create(PrivilegeDto resource) {

        privilegeRepository.save(new Privilege(resource));
    }

    @Override
    public void update(PrivilegeDto resource) {

        privilegeRepository.save(new Privilege(resource));
    }

    @Override
    public void delete(long id) {

        privilegeRepository.deleteById(id);
    }

    @Autowired
    public void setPrivilegeRepository(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }
}
