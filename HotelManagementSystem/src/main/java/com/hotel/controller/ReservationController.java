package com.hotel.controller;

import com.hotel.domain.Reservation;
import com.hotel.dto.ReservationDTO;
import com.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hotels/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //1-save a reservation & return message--CREATED
    //request : http://localhost8080/hotels/reservations + POST +json format body
    //responce : basarili + http status code(CREATED)
    //ayni url ile post, delete, update
    @PostMapping
    ResponseEntity<String> saveReservation(@Valid @RequestBody Reservation reservation){
        reservationService.saveReservation(reservation);
        return new ResponseEntity<>("Reservation is saved successfully!", HttpStatus.CREATED);

    }

    //READ
    //2-Get all reservation, return : List<Reservation>
    //http://localhost8080/hotels/reservations + GET
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations(){
        List<Reservation> reservationList = reservationService.getAllReservation();
        return ResponseEntity.ok(reservationList);
    }

    //3- tum reservationlari listeleme: READ
    //tum kayitlari page page(sayfa sayfa) gosterelim.return: Page<Reservation>
    //http://localhost8080/hotels/reservations/page?
    //                               page=1&--client hangi sayfayi gormek istiyor
    //                               size=10&--bir sayfada kac tane data gormek istiyoruz
    //                               sort=enteranceDate&--siralama hangi field a gore
    //                               direction=DESC(ASC) + GET--siralama hangi yonde olmali

    @GetMapping("/page")
    public ResponseEntity<Page<Reservation>> getAllPageReservation(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10") int size,
            @RequestParam(value = "sort",defaultValue ="enteranceDate" ) String sort,
            @RequestParam(value = "direction", defaultValue = "desc")Sort.Direction direction
    ){
        Pageable pageable = PageRequest.of(page,size,Sort.by(direction,sort));
        Page<Reservation> reservationPage = reservationService.getAllReservationsByPage(pageable);
        return new ResponseEntity<>(reservationPage, HttpStatus.OK);

    }

    //3-Get a reservation by Id,return : Reservation
    //http://localhost8080/hotels/reservations/2
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id){
        Reservation reservation = reservationService.getReservationById(id);
        return ResponseEntity.ok(reservation);
    }

    //4- delete a reservation by ID,return:Message
    //http://localhost8080/hotels/reservations/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservationById(@PathVariable("id") Long id){
        reservationService.deleteReservationById(id);
        return ResponseEntity.ok("Reservation is deleted successfully!");
        //return new ResponseEntity<>("Reservston is deleted", HttpStatus.OK);

    }

    //5- Update a Reservation with Using DTO, return String bir ifade olsun
    //dto ile ana obje korunur
    //http://localhost8080/hotels/reservations/update?id +JSON +PATCH
    @PatchMapping("/update")
    public ResponseEntity<String> updateReservation(@RequestParam("id") Long id, ReservationDTO reservationDTO){
        reservationService.updateReservationById(id, reservationDTO);
        return new ResponseEntity<>("Reservation is updated successfully!", HttpStatus.OK);

    }









}
