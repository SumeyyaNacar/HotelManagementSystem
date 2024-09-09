package com.hotel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.naming.Name;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    //@JsonIgnore
    private Guest guest;

    @ManyToOne
    private Room room;//burasinin list olup olmadigina bak

    //@NotBlank(message = "Lutfen bir tarih giriniz! ")
    @Column(nullable = false)
    private LocalDate enteranceDate;

    public void setEnteranceDate(LocalDate enteranceDate) {
        this.enteranceDate = LocalDate.now();
    }

    public void setExistDate(LocalDate existDate) {
        this.existDate = LocalDate.now();
    }

    //@NotBlank(message = "Lutfen bir tarih giriniz! ")
    @Column(nullable = false)
    private LocalDate existDate;







}
