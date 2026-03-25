package com.arrodevv.datagen;

import com.arrodevv.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModTagProvider {
    public static class Item extends FabricTagProvider.ItemTagProvider {
        public Item(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider wrapperLookup) {
            
        }
    }
    
    public static class Block extends FabricTagProvider.BlockTagProvider {
        public Block(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider wrapperLookup) {
            valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                    .add(ModBlocks.TITANIUM_BLOCK)
                    .setReplace(false);
            
            valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ModBlocks.TITANIUM_BLOCK)
                    .setReplace(false);
        }
    }
}
