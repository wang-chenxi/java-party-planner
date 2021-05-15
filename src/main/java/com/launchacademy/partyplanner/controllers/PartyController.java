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
public class PartyController {

  private PartyService partyService;
  @Autowired
  public PartyController(PartyService partyService){
    this.partyService = partyService;
  }

  @Autowired
  private GuestService guestService;

  @GetMapping
  public String root(){
    return "redirect:/parties";
  }

  @GetMapping("/parties")
public String getParties(Model model){
    model.addAttribute("parties", partyService.findAll());
    return "parties/index";
  }

  @GetMapping("/parties/{id}")
  public String showParty(@PathVariable int id, Model model){
    Guest invitedGuest = new Guest();
    model.addAttribute("party", partyService.findById(id));
    model.addAttribute("invitedGuests",guestService.findAllByPartyId(id));
    model.addAttribute("guests",guestService.findAll());
    model.addAttribute("invitedGuest", invitedGuest);
  return "parties/show";
  }

  @GetMapping("/parties/new")
  public String addParty(@ModelAttribute Party party){
    return "parties/new";
  }

  @PostMapping("/parties")
  public String addtheParty(@ModelAttribute Party party ){
this.partyService.add(party);
return "redirect:/parties";
  }

  @PostMapping("/parties/{id}")
  public String inviteGuest(@ModelAttribute Guest invitedGuest,  @PathVariable int id){
    System.out.println(invitedGuest.getId());
    Guest guest;
    guest = this.guestService.findGuest(invitedGuest.getId());
    this.guestService.invite(guest, id);
    this.guestService.updateGuest(guest);
    return "redirect:/parties/{id}";
  }
}
