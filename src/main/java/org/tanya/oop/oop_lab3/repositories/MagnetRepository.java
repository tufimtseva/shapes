package org.tanya.oop.oop_lab3.repositories;

import org.springframework.stereotype.Component;
import org.tanya.oop.oop_lab3.models.Magnet;

import java.util.List;

@Component
public class MagnetRepository {
    private static final List<Magnet> MAGNETS = List.of(new Magnet("small", 1.5f), new Magnet("medium", 2f), new Magnet("large", 2.5f));

    public List<Magnet> getAll() {
        return MAGNETS;
    }

    public Magnet getForSize(String size) {
        return getAll().stream().filter(magnet -> magnet.getName().equals(size)).findFirst().orElse(null);
    }
}
