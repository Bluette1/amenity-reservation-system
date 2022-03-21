package io.bootify.amenity_reservation_system.repos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.bootify.amenity_reservation_system.model.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

  List<Reservation> findReservationsByReservationDateAndStartTimeBeforeAndEndTimeAfterOrStartTimeBetween(
      LocalDate reservationDate, LocalTime startTime, LocalTime endTime, LocalTime startTime2, LocalTime endTime2);
}
