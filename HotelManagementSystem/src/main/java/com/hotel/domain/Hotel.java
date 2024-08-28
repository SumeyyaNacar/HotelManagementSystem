package com.hotel.domain;

import com.hotel.dto.HotelDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Isim bos olamaz!")
    @Column(nullable = false)
    private String name;


    @NotBlank(message = "Lutfen adres giriniz!")
    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "hotel")
    private List<Room> room=new ArrayList<>();





 // public Hotel(HotelDTO hotelDTO) {
 //     this.name = hotelDTO.getName();
 //     this.location = hotelDTO.getLocation();
 //     this.room = hotelDTO.getRoom();
 // }



}
