package com.arrodevv.datagen;

import com.arrodevv.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        simpleItem(itemModelGenerator, ModItems.TITANIUM_INGOT);
    }

    @Override
    public String getName() {
        return "ProfessionalRocketryModelProvider";
    }
    
    private void simpleItem(ItemModelGenerators itemModelGenerator, Item item) {
        itemModelGenerator.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }
}
