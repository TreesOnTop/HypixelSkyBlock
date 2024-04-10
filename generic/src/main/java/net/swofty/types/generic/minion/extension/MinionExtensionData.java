package net.swofty.types.generic.minion.extension;

import lombok.SneakyThrows;
import net.swofty.types.generic.item.ItemType;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MinionExtensionData {
    private final Map<Integer, MinionExtension> extensionData = new HashMap<>();

    public void setData(int slot, MinionExtension extension) {
        extensionData.put(slot, extension);
    }

    @SneakyThrows
    public MinionExtension getOfType(Class<? extends MinionExtension> clazz) {
        return extensionData.values().stream().filter(clazz::isInstance).findFirst().orElse(
                clazz.getConstructor(ItemType.class, Object.class).newInstance(null, null)
        );
    }

    @SneakyThrows
    public MinionExtension getMinionExtension(int slot) {
        if (!extensionData.containsKey(slot)) {
            MinionExtension extension = MinionExtensions.getFromSlot(slot).getInstance().getDeclaredConstructor(
                    ItemType.class, Object.class
            ).newInstance(null, null);

            extensionData.put(slot, extension);
        }

        return extensionData.get(slot);
    }

    public String toString() {
        JSONObject json = new JSONObject();
        extensionData.forEach((slot, entry) -> {
            JSONObject entryJson = new JSONObject();
            entryJson.put("serialized", entry.toString());
            json.put(String.valueOf(slot), entryJson);
        });
        return json.toString();
    }
    @SneakyThrows
    public static MinionExtensionData fromString(String string) {
        MinionExtensionData data = new MinionExtensionData();
        JSONObject json = new JSONObject(string);

        for (String key : json.keySet()) {
            JSONObject entryJson = json.getJSONObject(key);
            int slot = Integer.parseInt(key);

            MinionExtension extension = MinionExtensions.getFromSlot(slot).getInstance().getDeclaredConstructor(
                    ItemType.class, Object.class
            ).newInstance(null, null);

            extension.fromString(entryJson.getString("serialized"));

            data.setData(slot, extension);
        }
        return data;
    }
}