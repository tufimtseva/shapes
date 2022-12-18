package org.tanya.oop.oop_lab3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tanya.oop.oop_lab3.models.Magnet;
import org.tanya.oop.oop_lab3.models.Material;
import org.tanya.oop.oop_lab3.repositories.MagnetRepository;
import org.tanya.oop.oop_lab3.repositories.MaterialRepository;
import org.tanya.oop.oop_lab3.services.PriceService;


@Controller
public class MagnetController {
    @Autowired
    private MagnetRepository magnetRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    @Qualifier("usual")
    private PriceService priceService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("magnets", magnetRepository.getAll());
        return "home";
    }

    @GetMapping("/materials")
    public String materials(Model model, @RequestParam("magnetName") String selectedMagnetName) {
        Magnet selectedMagnet = magnetRepository.getForSize(selectedMagnetName);
        model.addAttribute("materials", priceService.getPrices(selectedMagnet));
        model.addAttribute("selectedMagnetName", selectedMagnetName);
        return "materials";
    }

    @GetMapping("/order")
    public String order(Model model, @RequestParam("magnetName") String magnetName, @RequestParam("material") String material) {
        model.addAttribute("magnetName", magnetName);
        model.addAttribute("material", material);
        Magnet selectedMagnet = magnetRepository.getForSize(magnetName);
        Material selectedMaterial = materialRepository.getForName(material);
        model.addAttribute("price", priceService.getPrice(selectedMagnet, selectedMaterial));
        return "order";
    }
}
