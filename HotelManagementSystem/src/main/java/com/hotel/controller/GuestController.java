package com.hotel.controller;

import com.hotel.domain.Guest;
import com.hotel.service.GuestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;//field inj.

    //1-save a guest & return message--CREATED
    //request : http://localhost8080/guests + POST +json format body
    //responce : basarili + http status code(CREATED)
    //ayni url ile post, delete, update
    @PostMapping
    public ResponseEntity<String> saveGuest(@Valid @RequestBody Guest guest){
        guestService.saveGuest(guest);
        return new ResponseEntity<>("Guest is saved successfully!", HttpStatus.CREATED);
    }

    //READ
    //2-Get all guests, return : List<Guest>
    //http://localhost8080/guests + GET
    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuest(){
        List<Guest> guestList = guestService.getAllGuest();
        return new ResponseEntity<>(guestList,HttpStatus.OK);
    }

    //3-Get a guest by Id,return : Guest
    //http://localhost:8080/guests/2
    @GetMapping("1/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable("id") Long id){
        Guest guest = guestService.getGuestById(id);
        return ResponseEntity.ok(guest);
    }

    //update 





}
