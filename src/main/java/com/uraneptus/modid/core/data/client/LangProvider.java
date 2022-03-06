package com.uraneptus.modid.core.data.client;

import com.uraneptus.modid.ModId;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LangProvider extends LanguageProvider {

    public LangProvider(DataGenerator gen) {
        super(gen, ModId.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

    }
}
