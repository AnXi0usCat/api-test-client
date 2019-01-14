package com.mishas.stuff.common.web;

public class UriMapper implements IUriMapper {

    public UriMapper() {
        super();
    }

    @Override
    public <T extends IDto> String getUriBase(Class<T> clazz) {
        String simpleName = clazz.getSimpleName().toString().toLowerCase();
        if (simpleName.endsWith("dto")) {
            simpleName = simpleName.substring(0, simpleName.length() - 3);
        }
        return simpleName;
    }
}
