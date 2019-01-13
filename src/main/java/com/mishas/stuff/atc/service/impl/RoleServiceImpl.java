package com.mishas.stuff.atc.service.impl;

import com.mishas.stuff.atc.persistence.dao.RoleRepository;
import com.mishas.stuff.atc.persistence.model.Role;
import com.mishas.stuff.atc.service.RoleService;
import com.mishas.stuff.atc.web.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    public RoleRepository roleRepository;

    @Override
    public RoleDto get(Long id) {

        return new RoleDto(roleRepository.getOne(id));
    }

    @Override
    public void create(RoleDto resource) {

        roleRepository.save(new Role(resource));
    }

    @Override
    public void update(RoleDto resource) {

        roleRepository.save(new Role(resource));
    }

    @Override
    public void delete(long id) {

        roleRepository.deleteById(id);
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
