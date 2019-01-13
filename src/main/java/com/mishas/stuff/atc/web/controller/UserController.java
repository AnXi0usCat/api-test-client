package com.mishas.stuff.atc.web.controller;

import com.mishas.stuff.atc.service.UserService;
import com.mishas.stuff.atc.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UserController {

    private UserService userService;

    // API

    // find - one
    @RequestMapping(value = "/api/v1/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUser(@PathVariable("id") final Long id) {
        return userService.get(id);
    }

    // create
    @RequestMapping(value = "/api/v1/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid final UserDto resource) {
        userService.create(resource);
    }

    // update
    @RequestMapping(value = "/api/v1/user", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody @Valid final UserDto resource) {
        userService.update(resource);
    }

    // delete
    @RequestMapping(value = "/api/v1/user/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("id") final Long id) {
        userService.delete(id);
    }

    // spring
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
