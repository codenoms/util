package com.github.codenoms.util.repo;

import com.github.codenoms.util.NamespacedKey;

import java.util.HashMap;
import java.util.Map;

public class TypeCache<T> extends TypeRepoDecorator<T>
{
    private final Map<NamespacedKey, T> typeMap = new HashMap<>();

    public TypeCache(TypeRepo<T> parent)
    {
        super(parent);
    }

    @Override
    public T getByNamespacedKey(NamespacedKey key)
    {
        return typeMap.computeIfAbsent(key, super::getByNamespacedKey);
    }
}
