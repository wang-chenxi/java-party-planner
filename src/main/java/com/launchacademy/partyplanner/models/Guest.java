package com.launchacademy.partyplanner.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="guests")
public class Guest {
  @Id
  @SequenceGenerator(name="guest_generator", sequenceName="guests_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="guest_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @Column(name="first_name", nullable = false)
  private String firstName;

  @Column(name="last_name",nullable = false)
  private String lastName;

  @Column(name="party_id")
  private Integer partyId;

}
