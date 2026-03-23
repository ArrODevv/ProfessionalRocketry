package com.arrodevv.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

import static com.arrodevv.ProfessionalRocketry.MODID;

public class ModBlocks {
    public static final Block TITANIUM_BLOCK = register("titanium_block",
            Block::new, BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.GRAY)
                    .sound(SoundType.IRON)
                    .strength(2.5f, 5f),
            true);
            
    private static <T extends Block> T register(String name, Function<BlockBehaviour.Properties, T> blockFactory, BlockBehaviour.Properties props, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        
        T block = blockFactory.apply(props.setId(blockKey));
        
        if(shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem item = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        }
        
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }
    
    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name));
    }
    
    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.accept(TITANIUM_BLOCK);
                    // ...
                });
    }
}
