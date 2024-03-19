package com.mrmelon54.ClockHud;

import com.mrmelon54.OmniPlay.OmniPlay;
import com.mrmelon54.OmniPlay.event.events.client.ClientGuiEvent;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.client.gui.screens.Screen;

import java.util.function.Supplier;

public class ClockHud {
    public static final String MOD_ID = "clock_hud";
    private static ConfigStructure config;

    public static ConfigStructure getConfig() {
        return config;
    }

    public static void init() {
        AutoConfig.register(ConfigStructure.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ConfigStructure.class).getConfig();
        OmniPlay.registerConfigScreen((mc, screen) -> createConfigScreen(screen).get());
        ClientGuiEvent.RENDER_HUD.register(new ClockHudRenderer());
    }

    public static Supplier<Screen> createConfigScreen(Screen screen) {
        return AutoConfig.getConfigScreen(ConfigStructure.class, screen);
    }
}
