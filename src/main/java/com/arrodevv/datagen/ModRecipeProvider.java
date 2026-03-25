package com.arrodevv.datagen;

import com.arrodevv.block.ModBlocks;
import com.arrodevv.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
            
                ingotBlockCombi(ModItems.TITANIUM_INGOT, ModBlocks.TITANIUM_BLOCK);
            }
            
            private void ingotsToBlock(Item ingot, Block block) {
                shaped(RecipeCategory.BUILDING_BLOCKS, block, 1)
                        .define('#', ingot)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .group("titanium")
                        .unlockedBy(getHasName(block), has(block))
                        .save(exporter);
            }
            
            private void blockToIngots(Item ingot, Block block) {
                shapeless(RecipeCategory.MISC, ingot, 9)
                        .requires(block)
                        .group("titanium")
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);
            }
            
            private void ingotBlockCombi(Item ingot, Block block) {
                ingotsToBlock(ingot, block);
                blockToIngots(ingot, block);
            }
        };
    }

    @Override
    public String getName() {
        return "ProfessionalRocketryRecipeProvider";
    }
    
}
