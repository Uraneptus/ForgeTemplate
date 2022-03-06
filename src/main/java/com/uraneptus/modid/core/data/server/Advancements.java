package com.uraneptus.modid.core.data.server;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Advancements extends AdvancementProvider {

    public Advancements(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }
}
