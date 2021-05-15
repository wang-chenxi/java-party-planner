package com.launchacademy.partyplanner.Seeders;
import com.google.inject.internal.util.Lists;
import com.launchacademy.partyplanner.models.Guest;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.GuestRepository;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner{
private PartyRepository partyRepository;
private GuestRepository guestRepository;

@Autowired Seeder(PartyRepository partyRepository, GuestRepository guestRepository){
  this.partyRepository = partyRepository;
  this.guestRepository = guestRepository;
}

@Override
  public void run(String... args) throws Exception{
  Party party1 = new Party();
  Party party2 = new Party();
  Party party3 = new Party();
  Guest guest1 = new Guest();
  Guest guest2 = new Guest();
  Guest guest3 = new Guest();

  if (Lists.newArrayList(partyRepository.findAll()).size() == 0) {
    party1.setName("Party 111");
    party1.setLocation("Seattle");
    party1.setDescription("Spring party");
    partyRepository.save(party1);

    party2.setName("Party @ Flower World");
    party2.setLocation("Snohomish");
    party2.setDescription("Summer party");
    partyRepository.save(party2);

    party3.setName("Party for harvest");
    party3.setLocation("Kirkland");
    party3.setDescription("Autumn party");
    partyRepository.save(party3);
  }

  if (Lists.newArrayList(guestRepository.findAll()).size() == 0) {
    guest1.setFirstName("Chenxi");
    guest1.setLastName("Wang");
    guestRepository.save(guest1);

    guest2.setFirstName("Lily");
    guest2.setLastName("Liu");
    guestRepository.save(guest2);

    guest3.setFirstName("Jeff");
    guest3.setLastName("Hu");
    guestRepository.save(guest3);
  }

}
}
