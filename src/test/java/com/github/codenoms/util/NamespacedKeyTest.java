package com.github.codenoms.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class NamespacedKeyTest
{
    @ParameterizedTest
    @CsvSource({
            "minecraft:stone, minecraft, stone",
            "stone, minecraft, stone",
            "namespace:key, namespace, key"
    })
    public void testParsing(String raw, String expectedNamespace, String expectedKey)
    {
        NamespacedKey key = new NamespacedKey(raw);
        Assertions.assertEquals(expectedKey, key.getKey());
        Assertions.assertEquals(expectedNamespace, key.getNamespace());
    }
}
