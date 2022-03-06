package com.uraneptus.modid;

import com.uraneptus.modid.core.data.client.LangProvider;
import com.uraneptus.modid.core.data.server.Advancements;
import com.uraneptus.modid.core.registry.FTBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ModId.MOD_ID)
@Mod.EventBusSubscriber(modid = ModId.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModId {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "modid";

    public ModId() {
        IEventBus eventBus =  FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);

        FTBlocks.BLOCKS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new LangProvider(generator));
        }
        if (event.includeServer()) {
            generator.addProvider(new Advancements(generator, helper));
        }
    }

}
