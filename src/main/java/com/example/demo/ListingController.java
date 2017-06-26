package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by student on 6/21/17.
 */
@Controller
public class ListingController {

    @Autowired
    private ListingRepository listingRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listing", new Listing());
        Iterable<Listing> listingList = listingRepository.findAll();
        model.addAttribute("listingList", listingList);
        return "index";
    }

    @PostMapping("/")
    public String catcher(@ModelAttribute Listing listing) {
       /* listingRepository.save(listing);*/
        return "result";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/addsubmit")
    public String addSubmit(@ModelAttribute Listing listing, Model model) {
        model.addAttribute(new Listing());
        listingRepository.save(listing);
        Iterable<Listing> listingList = listingRepository.findAll();
        model.addAttribute("listingList", listingList);
        return "index";
    }

}