package com.hotel.dto;

import com.hotel.domain.Reservation;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class GuestDTO {

    @NotBlank(message = "Lutfen gecerli bir deger giriniz!")
    private String name;

    //contact inf
   // @NotBlank(message = "Lutfen gecerli bir deger giriniz!")
   // private String tcNo;

    @NotBlank(message = "Lutfen gecerli bir deger giriniz!")
    private String medeniDurum;

    //private List<Reservation> reservation;


}
