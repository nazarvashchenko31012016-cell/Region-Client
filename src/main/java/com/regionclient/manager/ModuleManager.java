package com.regionclient.manager;

import com.regionclient.module.Module;
import com.regionclient.module.visuals.*;
import com.regionclient.module.esp.*;
import com.regionclient.module.effects.*;
import com.regionclient.module.hud.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();
    private final Map<String, Module> moduleMap = new HashMap<>();

    public void initialize() {
        // Visuals
        registerModule(new CustomSky());
        registerModule(new CustomFog());
        registerModule(new FullBright());
        registerModule(new TimeChanger());
        registerModule(new WeatherChanger());
        registerModule(new CustomSun());
        registerModule(new CustomMoon());
        registerModule(new CustomClouds());
        registerModule(new WorldColor());
        registerModule(new Ambience());

        // ESP
        registerModule(new TargetESP());
        registerModule(new PlayerESP());
        registerModule(new EntityESP());
        registerModule(new BoxESP());
        registerModule(new OutlineESP());
        registerModule(new GlowESP());
        registerModule(new ChamsESP());
        registerModule(new TracersESP());
        registerModule(new TargetHighlight());

        // Effects
        registerModule(new MotionBlur());
        registerModule(new HitColor());
        registerModule(new DamageTint());
        registerModule(new HitParticles());
        registerModule(new CriticalParticles());
        registerModule(new SwordTrail());
        registerModule(new ItemTrail());
        registerModule(new CustomParticles());
        registerModule(new ScreenEffects());
        registerModule(new KillEffect());

        // HUD
        registerModule(new Watermark());
        registerModule(new TargetHUD());
        registerModule(new ArmorHUD());
        registerModule(new PotionHUD());
        registerModule(new Keystrokes());
        registerModule(new CPSCounter());
        registerModule(new FPSCounter());
        registerModule(new PingDisplay());
        registerModule(new CoordinatesDisplay());
        registerModule(new CustomCrosshair());
        registerModule(new CustomScoreboard());
        registerModule(new CustomChat());
        registerModule(new InventoryHUD());
        registerModule(new SessionInfo());
    }

    public void registerModule(Module module) {
        modules.add(module);
        moduleMap.put(module.getName().toLowerCase(), module);
    }

    public Module getModule(String name) {
        return moduleMap.get(name.toLowerCase());
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getEnabledModules() {
        return modules.stream().filter(Module::isEnabled).toList();
    }

    public void onClientTick() {
        for (Module module : getEnabledModules()) {
            module.onTick();
        }
    }

    public void onRender() {
        for (Module module : getEnabledModules()) {
            module.onRender();
        }
    }
}
