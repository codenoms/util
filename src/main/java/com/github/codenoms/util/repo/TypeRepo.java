package com.github.codenoms.util.repo;

import com.github.codenoms.util.NamespacedKey;

public interface TypeRepo<T>
{
    default T getByNamespacedKey(String key)
    {
        return getByNamespacedKey(new NamespacedKey(key));
    }

    T getByNamespacedKey(NamespacedKey key);
}
