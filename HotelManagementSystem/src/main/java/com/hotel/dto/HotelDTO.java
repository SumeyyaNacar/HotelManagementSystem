package com.hotel.dto;

import com.hotel.domain.Room;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class HotelDTO {

    @NotBlank(message = "Isim bos olamaz!")
    private String name;


    @NotBlank(message = "Lutfen adres giriniz!")
    private String location;

    private List<Room> room;

}
