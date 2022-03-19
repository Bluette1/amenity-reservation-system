package io.bootify.amenity_reservation_system.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String reservationDate;

    @NotNull
    @Size(max = 255)
    private String startTime;

    @NotNull
    @Size(max = 255)
    private String endTime;

    @NotNull
    private Long user;

}
