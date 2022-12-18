package org.tanya.oop.oop_lab3.models;

public class Material {
    private final String name;
    private final float cost;

    public Material(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }
}
