package de.tr7zw.changeme.nbtapi;

import de.tr7zw.changeme.nbtapi.utils.nmsmappings.ReflectionMethod;
import java.util.Map;
import org.bukkit.persistence.PersistentDataContainer;

public class NBTPersistentDataContainer extends NBTCompound {

    private final PersistentDataContainer container;

    public NBTPersistentDataContainer(PersistentDataContainer container) {
        super(null, null);
        this.container = container;
    }

    @Override
    public Object getCompound() {
        return ReflectionMethod.CRAFT_PERSISTENT_DATA_CONTAINER_TO_TAG.run(container);
    }

    @Override
    protected void setCompound(Object compound) {
        @SuppressWarnings("unchecked")
        Map<Object, Object> map =
                (Map<Object, Object>) ReflectionMethod.CRAFT_PERSISTENT_DATA_CONTAINER_GET_MAP.run(container);
        map.clear();
        ReflectionMethod.CRAFT_PERSISTENT_DATA_CONTAINER_PUT_ALL.run(container, compound);
    }
}
