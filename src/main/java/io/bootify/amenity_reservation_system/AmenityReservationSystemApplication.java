package io.bootify.amenity_reservation_system;

import io.bootify.amenity_reservation_system.model.AmenityType;
import io.bootify.amenity_reservation_system.model.Capacity;
import io.bootify.amenity_reservation_system.model.Reservation;
import io.bootify.amenity_reservation_system.model.User;
import io.bootify.amenity_reservation_system.repos.CapacityRepository;
import io.bootify.amenity_reservation_system.repos.ReservationRepository;
import io.bootify.amenity_reservation_system.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AmenityReservationSystemApplication {
  private Map<AmenityType, Integer> initialCapacities =
      new HashMap<>() {
        {
          put(AmenityType.GYM, 20);
          put(AmenityType.POOL, 4);
          put(AmenityType.SAUNA, 1);
        }
      };

  public static void main(String[] args) {
    SpringApplication.run(AmenityReservationSystemApplication.class, args);
  }

  @Bean
  public CommandLineRunner loadData(UserRepository userRepository,
      ReservationRepository reservationRepository, CapacityRepository capacityRepository) {
    return (args) -> {
      User user1 = User.builder()
          .fullName("Mary Jane")
          .username("maryjane")
          .passwordHash(bCryptPasswordEncoder().encode("password"))
          .build();

      userRepository.save(user1);

      User user2 = User.builder()
          .fullName("Martha Jane")
          .username("marthajane")
          .passwordHash(bCryptPasswordEncoder().encode("password"))
          .build();

      userRepository.save(user2);

      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      Date date = new Date();
      LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      Reservation reservation = Reservation.builder()
          .reservationDate(localDate)
          .startTime(LocalTime.of(12, 00))
          .endTime(LocalTime.of(13, 00))
          .user(user1)
          .amenityType(AmenityType.POOL)
          .build();

      reservationRepository.save(reservation);

      for (AmenityType amenityType : initialCapacities.keySet()) {
        capacityRepository.save(new Capacity(amenityType, initialCapacities.get(amenityType)));
      }
    };
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
