package com.hotel.domain;

import lombok.*;

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
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Lutfen oda numarasi giriniz !")
    @Column(nullable = false)
    private String roomNumber;

    @NotBlank(message = "Lutfen oda tipini giriniz !")
    @Column(nullable = false)
    private String roomType;

    @ManyToOne()
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservation;




}
