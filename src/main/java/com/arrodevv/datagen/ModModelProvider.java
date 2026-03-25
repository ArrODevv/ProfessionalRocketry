package com.arrodevv.datagen;

import com.arrodevv.block.ModBlocks;
import com.arrodevv.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class ModModelProvider extends FabricModelProvider {
    private @Nullable BlockModelGenerators blockStateModelGenerator;
    private @Nullable ItemModelGenerators itemModelGenerator;
    
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        this.blockStateModelGenerator = blockStateModelGenerator;
        
        simpleBlock(ModBlocks.TITANIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        this.itemModelGenerator = itemModelGenerator;
        
        simpleItem(ModItems.TITANIUM_INGOT);
    }

    @Override
    public String getName() {
        return "ProfessionalRocketryModelProvider";
    }
    
    private void simpleItem(Item item) {
        assert itemModelGenerator != null;
        itemModelGenerator.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }
    
    private void simpleBlock(Block block) {
        assert blockStateModelGenerator != null;
        blockStateModelGenerator.createTrivialCube(block);
    }
}
