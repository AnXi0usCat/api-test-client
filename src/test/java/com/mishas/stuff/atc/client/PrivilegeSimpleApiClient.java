package com.mishas.stuff.atc.client;

import com.mishas.stuff.atc.web.dto.PrivilegeDto;

public class PrivilegeSimpleApiClient extends GenericSimpleApiClient<PrivilegeDto> {

    public PrivilegeSimpleApiClient() {
        super(PrivilegeDto.class);
    }

    @Override
    public String getUri() {
        return paths.getPrivilegeUri();
    }
}
