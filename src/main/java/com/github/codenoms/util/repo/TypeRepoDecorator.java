package com.github.codenoms.util.repo;

import com.github.codenoms.util.NamespacedKey;

public abstract class TypeRepoDecorator<T> implements TypeRepo<T>
{
    private final TypeRepo<T> parent;

    public TypeRepoDecorator(TypeRepo<T> parent)
    {
        this.parent = parent;
    }

    @Override
    public T getByNamespacedKey(NamespacedKey key)
    {
        return parent.getByNamespacedKey(key);
    }
}
