package org.tanya.oop.oop_lab3.repositories;

import org.springframework.stereotype.Component;
import org.tanya.oop.oop_lab3.models.Magnet;
import org.tanya.oop.oop_lab3.models.Material;

import java.util.List;

@Component
public class MaterialRepository {
    private static final List<Material> MATERIALS = List.of(
            new Material("glass", 3),
            new Material("plastic", 1),
            new Material("wood", 2)
    );

    public List<Material> getAll() {
        return MATERIALS;
    }

    public Material getForName(String name) {
        return getAll().stream().filter(material -> material.getName().equals(name)).findFirst().orElse(null);
    }
}
