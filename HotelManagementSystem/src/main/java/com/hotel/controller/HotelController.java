package com.hotel.controller;

import com.hotel.domain.Hotel;
import com.hotel.dto.HotelDTO;
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

    //CREATE
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

    //READ BY ID
    //3-Get a hotel by Id,return : Hotel
    //request : http://localhost:8080/hotels/2
    //response : return : Hotel
    @GetMapping("/{identity}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id){
        Hotel hotel = hotelService.getHotelById(id);
        return ResponseEntity.ok(hotel);
    }

    //DELETE
    //4- delete a hotel by ID, return:Message
    //request : http://localhost:8080/books/2
    //response : Message
    @DeleteMapping("/{deleteId}")
    public ResponseEntity<String > deleteHotel(@PathVariable Long id){
        hotelService.deleteHotelById(id);
        return ResponseEntity.ok("Hotel basariyla silindi!");
    }

    //UPDATE
    // Update a Hotel with Using DTO, return String bir ifade olsun
    //dto ile ana obje korunur
    //http://localhost:8080/hotels/update?id +JSON +PUT
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateHotel(@RequestParam("id") Long id,//query parametresindeki id @RequestParam anotasyonu ile alinip Long tipinde id ye atanacak
                                              @Valid @RequestBody HotelDTO hotelDTO){//JSON formatindaki bilgiler @RequestBody anotasyonu ile HotelDto objesine atanacak
        hotelService.updateHotelById(id, hotelDTO);

        return new ResponseEntity<>("Hotel basariyla guncellendi.",HttpStatus.OK);
        //return ResponseEntity.ok("Hotel basariyla guncellendi...");

    }

    //8-Get Hotels with Page








}
