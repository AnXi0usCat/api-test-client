package com.mishas.stuff.atc.client;

import com.mishas.stuff.atc.web.dto.RoleDto;
import org.springframework.stereotype.Component;

@Component
public class RoleSimpleApiClient extends GenericSimpleApiClient<RoleDto> {

    public RoleSimpleApiClient() {
        super(RoleDto.class);
    }

    @Override
    public String getUri() {
        return paths.getRoleUri();
    }
}
