package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Guest;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.services.GuestService;
import com.launchacademy.partyplanner.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class GuestController {

  private GuestService guestService;
  @Autowired
  public GuestController(GuestService guestService){
    this.guestService = guestService;
  }


  @GetMapping("/guests")
  public String getGuests(Model model){
    model.addAttribute("guests", guestService.findAll());
    return "guests/index";
  }

  @GetMapping("/guests/new")
  public String addGuest(@ModelAttribute Guest guest){
    return "guests/new";
  }

  @PostMapping("/guests")
  public String addtheGuest(@ModelAttribute Guest guest ){
    this.guestService.add(guest);
    return "redirect:/guest";
  }

}
