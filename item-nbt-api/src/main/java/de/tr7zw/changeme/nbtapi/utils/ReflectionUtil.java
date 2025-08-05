package de.tr7zw.changeme.nbtapi.utils;

import de.tr7zw.changeme.nbtapi.NbtApiException;
import de.tr7zw.changeme.nbtapi.utils.nmsmappings.MojangToMapping;
import java.lang.reflect.Field;

public final class ReflectionUtil {

    public static Field getMappedField(Class<?> clazz, String mapping) {
        String mojmapName = mapping.split("#")[1];
        try {
            return clazz.getField(mojmapName);
        } catch (NoSuchFieldException | SecurityException e) {
            // not Mojamp, try remapped
        }
        try {
            return clazz.getDeclaredField(MojangToMapping.getMapping().get(mapping));
        } catch (Exception e) {
            throw new NbtApiException("Unable to find field " + mapping + " in class " + clazz.getName(), e);
        }
    }
}
