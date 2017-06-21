package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by student on 6/21/17.
 */
@Controller
public class ListingController {


    /*@Autowired
    private ListingRepository listingRepository;*/
    @GetMapping("/listing")
    public String index(Model model){
        model.addAttribute("listing", new Listing());
        return"index";
    }

    @PostMapping("/listing")
    public String catcher(@ModelAttribute Listing listing){
        /*listingRepository.save(listing);*/
        return "result";
    }

}
