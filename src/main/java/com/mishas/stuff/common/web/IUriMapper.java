package com.mishas.stuff.common.web;

public interface IUriMapper {

    public abstract <T extends IDto> String getUriBase(final Class<T> clazz);
}
