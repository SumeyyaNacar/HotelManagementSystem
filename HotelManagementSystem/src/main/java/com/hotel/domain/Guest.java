package com.hotel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Lutfen gecerli bir deger giriniz!")
    @Column(nullable = false)
    private String name;

    //contact inf
    @NotBlank(message = "Lutfen gecerli bir deger giriniz!")
    @Column(unique = true, nullable = false)
    private String tcNo;

    @NotBlank(message = "Lutfen gecerli bir deger giriniz!")
    @Column(nullable = false)
    private String medeniDurum;

    @OneToMany(mappedBy = "guest")
    //@JsonIgnore
    private List<Reservation> reservation;




}
