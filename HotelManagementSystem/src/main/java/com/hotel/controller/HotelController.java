package com.hotel.controller;

import com.hotel.domain.Hotel;
import com.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor//constr. inj
//http:localhost8080/hotels
public class HotelController {

    private final HotelService hotelService;

    //1-save a hotel & return message--CREATED
    //request : http://localhost8080/hotels + POST +json format body
    //responce : basarili + http status code(CREATED)
    //ayni url ile post, delete, update
    @PostMapping
    public ResponseEntity<String> saveHotel(@Valid @RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
        return new ResponseEntity<>("Hotel basariyla kaydedildi.", HttpStatus.CREATED);//201
    }
    
    //READ
    //2-Get all hotels, return : List<Hotel> + OK
    //http://localhost8080/hotels + GET

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getHotels();
        return ResponseEntity.ok(hotels);//200--basarili
    }



}
