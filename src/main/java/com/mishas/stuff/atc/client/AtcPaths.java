package com.mishas.stuff.atc.client;

import com.mishas.stuff.atc.web.dto.PrivilegeDto;
import com.mishas.stuff.atc.web.dto.RoleDto;
import com.mishas.stuff.atc.web.dto.UserDto;
import com.mishas.stuff.common.client.CommonPaths;
import com.mishas.stuff.common.web.IUriMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AtcPaths {

    private CommonPaths commonPaths;

    private IUriMapper uriMapper;

    // API

    public final String getContext() {
        return commonPaths.getServerRoot();
    }

    public final String getRootUri() {
        return getContext() + "/api/v1/";
    }

    public final String getUserUri() {
        return getRootUri() + uriMapper.getUriBase(UserDto.class);
    }

    public final String getRoleUri() {
        return getRootUri() + uriMapper.getUriBase(RoleDto.class);
    }

    public final String getPrivilegeUri() {
        return getRootUri() + uriMapper.getUriBase(PrivilegeDto.class);
    }

    // Spring

    @Autowired
    public void setCommonPaths(CommonPaths commonPaths) {
        this.commonPaths = commonPaths;
    }

    @Autowired
    public void setUriMaper(IUriMapper uriMapper) {
        this.uriMapper = uriMapper;
    }
}
