package com.ndirangu.health.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "order")
@ApiModel(description = "All details about an order. ")
public class Order {
  @Id
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @GeneratedValue(generator = "uuid")
  private UUID id;
  private String name;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "patient_id",nullable = false)
  @JsonIgnore
  private Patient patient;

  public Order(){}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }
}
