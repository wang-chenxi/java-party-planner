package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Guest;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Integer> {
  List<Guest> findAll();

  public List<Guest> findAllByPartyId(int partyId);


}
