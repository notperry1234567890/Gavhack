package me.gavin.mimeware.mimeware.module;

import me.gavin.mimeware.mimeware.module.mods.ChatSuffixMod;
import me.gavin.mimeware.mimeware.module.mods.SprintMod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {

    public ModuleManager() {
        init();
    }

    ArrayList<Module> modules = new ArrayList<>();

    private void init() {
        // combat

        // render
        add(new SprintMod());

        // movement

        // world

        // misc
        add(new ChatSuffixMod());
    }

    private void add(Module m) {
        modules.add(m);
    }

    public Module getMod(String name) {
        return modules.stream().filter(mod -> mod.name.equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public List<Module> getModsByCategory(Category category) {
        return modules.stream().filter(mod -> mod.category == category).collect(Collectors.toList());
    }

    public ArrayList<Module> getMods() {
        return modules;
    }
}
