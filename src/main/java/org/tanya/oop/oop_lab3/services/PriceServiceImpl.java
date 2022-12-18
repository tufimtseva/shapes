package org.tanya.oop.oop_lab3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tanya.oop.oop_lab3.models.Magnet;
import org.tanya.oop.oop_lab3.models.Material;
import org.tanya.oop.oop_lab3.repositories.MaterialRepository;

import java.util.*;
import java.util.stream.Collectors;

@Component("usual")
public class PriceServiceImpl extends PriceService {
    public float getPrice(Magnet magnet, Material material) {
        return magnet.getArea() * material.getCost();
    }
}
