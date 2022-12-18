package org.tanya.oop.oop_lab3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.tanya.oop.oop_lab3.models.Magnet;
import org.tanya.oop.oop_lab3.models.Material;
import org.tanya.oop.oop_lab3.repositories.MaterialRepository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class PriceService {
    @Autowired
    private MaterialRepository materialRepository;

    public Map<String, Float> getPrices(Magnet magnet) {
        Map<String, Float> materialPrices = new HashMap<>();
        for (Material material : materialRepository.getAll()) {
            materialPrices.put(material.getName(), getPrice(magnet, material));
        }

        return materialPrices.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public abstract float getPrice(Magnet magnet, Material material);
}
