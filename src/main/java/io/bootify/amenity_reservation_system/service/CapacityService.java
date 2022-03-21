package io.bootify.amenity_reservation_system.service;

import io.bootify.amenity_reservation_system.model.AmenityType;
import io.bootify.amenity_reservation_system.model.Capacity;
import io.bootify.amenity_reservation_system.repos.CapacityRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CapacityService {

    private final CapacityRepository CapacityRepository;

    public CapacityService(final CapacityRepository CapacityRepository) {
        this.CapacityRepository = CapacityRepository;
    }

    public List<Capacity> findAll() {
        return CapacityRepository.findAll();
    }

    public Capacity get(final Long id) {
        return CapacityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final Capacity Capacity) {
        return CapacityRepository.save(Capacity).getId();
    }

    public void update(final Long id, final Capacity Capacity) {
        final Capacity existingCapacity = CapacityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        CapacityRepository.save(Capacity);
    }

    public void delete(final Long id) {
        CapacityRepository.deleteById(id);
    }

    public Capacity findByAmenityType(AmenityType amenityType ) {
        return CapacityRepository.findByAmenityType(amenityType);
    }
}
