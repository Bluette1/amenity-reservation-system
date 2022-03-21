package io.bootify.amenity_reservation_system.service;

public class CapacityFullException extends Throwable{

  public CapacityFullException(String message) {
    super(message);
  }

}
