package com.hotel.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class RoomDTO {
    @NotBlank(message = "Lutfen oda numarasi giriniz !")
    private String roomNumber;

    @NotBlank(message = "Lutfen oda tipini giriniz !")
    private String roomType;
}
