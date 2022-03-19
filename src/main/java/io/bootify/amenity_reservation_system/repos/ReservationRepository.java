package io.bootify.amenity_reservation_system.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.bootify.amenity_reservation_system.model.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
