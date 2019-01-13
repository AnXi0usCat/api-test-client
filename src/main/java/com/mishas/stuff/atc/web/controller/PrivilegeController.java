package com.mishas.stuff.atc.web.controller;

import com.mishas.stuff.atc.service.PrivilegeService;
import com.mishas.stuff.atc.web.dto.PrivilegeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PrivilegeController {

    private PrivilegeService privilegeService;

    // API

    // get
    @RequestMapping(value = "/api/v1/privilege/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PrivilegeDto getPrivilege(@PathVariable("id") final Long id) {
        return privilegeService.get(id);
    }

    // create
    @RequestMapping(value = "/api/v1/privilege", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPrivilege(@RequestBody @Valid final PrivilegeDto resource) {
        privilegeService.create(resource);
    }

    // update
    @RequestMapping(value = "/api/v1/privilege", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePrivilege(@RequestBody @Valid final PrivilegeDto resource) {
        privilegeService.update(resource);
    }
    // delete
    @RequestMapping(value = "/api/v1/privilege/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrivielege(@PathVariable("id") final Long id) {
        privilegeService.delete(id);
    }


    // spring
    @Autowired
    public void setPrivilegeService(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }
}
