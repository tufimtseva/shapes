package org.tanya.oop.oop_lab3.models;

public class Magnet {
    private final String name;
    private final float area;

    public Magnet(String name, float area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public Float getArea() {
        return area;
    }
}
