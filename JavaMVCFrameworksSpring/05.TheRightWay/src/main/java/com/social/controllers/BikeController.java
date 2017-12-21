package com.social.controllers;

import com.social.exceptions.BikeNotFoundException;
import com.social.models.viewModels.BikeViewModel;
import com.social.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BikeController {

    private final BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/bikes")
    public String getBikes(Model model, @PageableDefault(size = 10) Pageable pageable) {
//        List<BikeViewModel> bikeViewModels = this.bikeService.findAll();
//        model.addAttribute("bikes", bikeViewModels);

        Page<BikeViewModel> bikes = this.bikeService.findAll(pageable);
        model.addAttribute("bikes", bikes);

        return "bikes";
    }

    @GetMapping("/bikes/show/{id}")
    public String showBike(Model model, @PathVariable long id) {
        BikeViewModel bikeViewModel = this.bikeService.findById(id);
        model.addAttribute("bike", bikeViewModel);
        return "bike-show";
    }

    @ExceptionHandler(BikeNotFoundException.class)
    public String catchBikeNotFoundException(){
        return "exceptions/bike-not-found";
    }
}