package io.bootify.amenity_reservation_system.repos;

import io.bootify.amenity_reservation_system.model.AmenityType;
import io.bootify.amenity_reservation_system.model.Capacity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CapacityRepository extends JpaRepository<Capacity, Long> {

  Capacity findByAmenityType(AmenityType amenityType);
}
