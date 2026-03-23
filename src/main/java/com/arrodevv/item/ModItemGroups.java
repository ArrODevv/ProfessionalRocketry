package com.arrodevv.item;

import com.arrodevv.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

import static com.arrodevv.ProfessionalRocketry.MODID;

public class ModItemGroups {
    public static final ResourceKey<CreativeModeTab> PR_CREATIVE_TAB_KEY =
            ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                    Identifier.fromNamespaceAndPath(MODID, "professionalrocketry_tab"));
    public static final CreativeModeTab PR_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.TITANIUM_INGOT))
            .title(Component.translatable("itemGroup.professionalrocketry.professionalrocketry_tab"))
            .displayItems((p1, output) -> {
                output.accept(ModItems.TITANIUM_INGOT);
                output.accept(ModBlocks.TITANIUM_BLOCK);
            })
            .build();
    
    public static void init() {
        
    }
}
