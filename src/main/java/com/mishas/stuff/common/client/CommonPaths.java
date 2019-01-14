package com.mishas.stuff.common.client;

import org.springframework.beans.factory.annotation.Value;

public final class CommonPaths {

    @Value("${http.protocol}")
    private String protocol;
    @Value("${http.host}")
    private String host;
    @Value("${server.port}")
    private String port;

    public CommonPaths() {
        super();
    }

    // API

    public final String getServerRoot() {
        if (port.equals("80")) {
            return protocol + "://" + host;
        }
        return protocol + "://" + host + ":" + port;
    }

}
