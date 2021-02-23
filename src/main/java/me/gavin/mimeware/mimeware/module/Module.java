package me.gavin.mimeware.mimeware.module;

public abstract class Module {

    String name;
    Category category;

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
