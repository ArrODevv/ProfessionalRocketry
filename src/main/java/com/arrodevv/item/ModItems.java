package com.arrodevv.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

import static com.arrodevv.ProfessionalRocketry.MODID;

public class ModItems {
    public static final Item TITANIUM_INGOT = registerSimpleItem("titanium_ingot");
    
    private static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties props) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name));
        
        T item = itemFactory.apply(props.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        
        return item;
    }
    
    private static Item registerSimpleItem(String name) {
        return register(name, Item::new, new Item.Properties());
    }
    
    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
                .register((itemGroup) -> {
                    itemGroup.accept(TITANIUM_INGOT);
                });
    }
}
