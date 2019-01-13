package com.mishas.stuff.common.service;

public interface GenericService<T> {

    public abstract T get(Long id);

    public abstract void create(T resource);

    public abstract void update(T resource);

    public abstract void delete(long id);
}
