package io.bootify.amenity_reservation_system.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.bootify.amenity_reservation_system.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
  User findUserByUsername(String username);
}
