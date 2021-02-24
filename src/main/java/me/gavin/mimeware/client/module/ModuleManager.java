package me.gavin.mimeware.client.module;

import me.gavin.mimeware.client.module.mods.*;

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

        // movement
        add(new Sprint());

        // world
        add(new FastPlace());

        // misc
        add(new ChatSuffix());
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
