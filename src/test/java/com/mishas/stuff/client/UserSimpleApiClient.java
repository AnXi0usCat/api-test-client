package com.mishas.stuff.client;

import com.mishas.stuff.atc.web.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserSimpleApiClient extends GenericSimpleApiClient<UserDto> {

    public UserSimpleApiClient() {
        super(UserDto.class);
    }

    @Override
    public String getUri() {
        return paths.getUserUri();
    }
}
