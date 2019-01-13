package com.mishas.stuff.atc.service.impl;

import com.mishas.stuff.atc.persistence.dao.UserRepository;
import com.mishas.stuff.atc.persistence.model.User;
import com.mishas.stuff.atc.service.UserService;
import com.mishas.stuff.atc.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto get(Long id) {
        return new UserDto(userRepository.getOne(id));
    }

    @Override
    public void create(UserDto resource) {
        userRepository.save(new User(resource));
    }

    @Override
    public void update(UserDto resource) {
        userRepository.save(new User(resource));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
