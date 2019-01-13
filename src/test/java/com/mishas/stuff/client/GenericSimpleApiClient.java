package com.mishas.stuff.client;

import com.mishas.stuff.atc.client.AtcPaths;
import com.mishas.stuff.common.web.INameableDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericSimpleApiClient<T extends INameableDto> {

    @Autowired
    protected AtcPaths paths;

    private final Class<T> clazz;

    public GenericSimpleApiClient(Class<T> clazz) {
        this.clazz = clazz;
    }

    // API

    // find - one


    // create


    // update


    // delete

    // API - other

    public abstract String getUri();

}
