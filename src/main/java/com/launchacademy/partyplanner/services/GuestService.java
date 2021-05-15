package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Guest;
import com.launchacademy.partyplanner.repositories.GuestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestService {

  private GuestRepository guestRepository;

  @Autowired
  public GuestService(GuestRepository guestRepository){
    this.guestRepository = guestRepository;
  }

  public List<Guest> findAll(){
    return this.guestRepository.findAll();
  }

  public void add(Guest guest){
    this.guestRepository.save(guest);
  }

  public void updateGuest(Guest guest){
    this.guestRepository.save(guest);
  }

  public void invite(Guest guest, Integer partyId){
    guest.setPartyId(partyId);
  }

  public Guest findGuest(int id){return this.guestRepository.findById(id).get();}

  public List<Guest> findAllByPartyId(int partyId){
    return this.guestRepository.findAllByPartyId(partyId);}

}
