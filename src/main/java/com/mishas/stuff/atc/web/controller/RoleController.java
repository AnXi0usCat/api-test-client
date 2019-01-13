package com.mishas.stuff.atc.web.controller;

import com.mishas.stuff.atc.service.RoleService;
import com.mishas.stuff.atc.web.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RoleController {

    private RoleService roleService;

    // API

    // get
    @RequestMapping(value = "/api/v1/role/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RoleDto getRole(@PathVariable("id") final Long id) {
        return roleService.get(id);
    }

    // create
    @RequestMapping(value = "/api/v1/role", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@RequestBody @Valid final RoleDto resource) {
        roleService.create(resource);
    }

    // update
    @RequestMapping(value = "/api/v1/role", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateRole(@RequestBody @Valid final RoleDto resource) {
        roleService.update(resource);
    }

    // delete
    @RequestMapping(value = "/api/v1/role/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable("id") final Long id) {
        roleService.delete(id);
    }

    // spring
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
