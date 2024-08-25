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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Lutfen gecerli bir deger giriniz!")
    @Column(nullable = false)
    private String name;


    @NotBlank(message = "Lutfen gecerli bir deger giriniz!")
    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "hotel")
    private List<Room> room;




}
