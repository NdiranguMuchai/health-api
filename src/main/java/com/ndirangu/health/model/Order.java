package com.ndirangu.health.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Order {
  @Id
  private UUID id;

  public Order(){};
}
