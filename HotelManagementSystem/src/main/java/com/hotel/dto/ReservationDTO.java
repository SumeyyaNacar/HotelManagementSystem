package com.hotel.dto;

import com.hotel.domain.Guest;
import com.hotel.domain.Room;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class ReservationDTO {

    @NotBlank(message = "Lutfen gecerli bir deger giriniz! ")
    private Guest guest;

    private Room room;//burasinin list olup olmadigina bak

    @NotBlank(message = "Lutfen bir tarih giriniz! ")
    private LocalDate enteranceDate;

    @NotBlank(message = "Lutfen bir tarih giriniz! ")
    private LocalDate existDate;



}
