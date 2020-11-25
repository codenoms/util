package com.github.codenoms.util;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class NamespacedKey
{
    private final String namespace;
    private final String key;

    public NamespacedKey(String key)
    {
        if(key == null)
            throw new NullPointerException("key is null");
        String[] splits = key.contains(":") ? new String[]{"minecraft", key}
                                            : key.split(":");
        this.key       = splits[splits.length - 1];
        this.namespace = Stream.of(splits)
                               .limit(splits.length - 1)
                               .collect(Collectors.joining(":"));
    }

    public String getNamespace()
    {
        return namespace;
    }

    public String getKey()
    {
        return key;
    }

    @Override
    public String toString()
    {
        return namespace + ":" + key;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        NamespacedKey that = (NamespacedKey) o;
        return namespace.equals(that.namespace) &&
               key.equals(that.key);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(namespace, key);
    }
}
