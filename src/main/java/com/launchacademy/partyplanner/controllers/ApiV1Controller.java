package com.launchacademy.partyplanner.controllers;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.models.Guest;
import com.launchacademy.partyplanner.repositories.GuestRepository;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import com.launchacademy.partyplanner.services.GuestService;
import com.launchacademy.partyplanner.services.PartyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiV1Controller {

  @Autowired
  PartyRepository partyRepository;

  @Autowired
  GuestRepository guestRepository;

  @GetMapping("/parties")
  public List<Party>getParties(){
    return partyRepository.findAll();
  }

  @GetMapping("/guests")
  public List<Guest>getGuests(){
    return guestRepository.findAll();
  }

}
