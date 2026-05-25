package com.example;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("boatfreezemod");

    @Override
    public void onInitialize() {
        LOGGER.info("1.16 Boat MLG Freeze Emulator loaded for Minecraft 26.1.2!");
    }
}
