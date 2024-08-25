package com.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Lutfen oda numarasi giriniz !")
    @Column(nullable = false)
    private String roomNumber;

    @NotBlank(message = "Lutfen oda tipini giriniz !")
    @Column(nullable = false)
    private String roomType;

    @ManyToOne()
    private Hotel hotel;

    //tekrar bakilacak
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservation;




}
