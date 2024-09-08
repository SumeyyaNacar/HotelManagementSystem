package com.hotel.controller;

import com.hotel.domain.Guest;
import com.hotel.dto.GuestDTO;
import com.hotel.service.GuestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    //4- Update a Guest with Id Using DTO, return String bir ifade olsun
    //dto ile ana obje korunur
    //http://localhost:8080/guests/update/2 +JSON body + POST
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateGuest(@PathVariable("id") Long id, @Valid @RequestBody GuestDTO guestDTO){
        guestService.updateGuestById(id, guestDTO);
        return ResponseEntity.ok("Guest is updated successfully. ID : "+ id);
    }

    //5- delete a Guest by ID,return:Message
    //http://localhost:8080/guests/delete/2
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGuestById(@PathVariable("id") Long id){
        guestService.deleteGuestById(id);
        return new ResponseEntity<>("Guest id deleted successfully", HttpStatus.OK);
    }

    //6-Get Guests with Page
    //http://localhost:8080/guests/page?
    //                               page=1&--client hangi sayfayi gormek istiyor
    //                               size=10&--bir sayfada kac tane data gormek istiyoruz
    //                               sort=name&--siralama hangi field a gore
    //                               direction=DESC(ASC) + GET--siralama hangi yonde olmali
    @GetMapping("/page")
    public ResponseEntity<Page<Guest>> getAllGuestsByPage(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "name") String sort,
            @RequestParam(value = "direction", defaultValue = "desc") Sort.Direction direction){


        Pageable pageable = PageRequest.of(page,size,Sort.by(direction,sort));

        Page<Guest> guestPage = guestService.getAllGuestByPage(pageable);

        return new ResponseEntity<>(guestPage,HttpStatus.OK);
    }



}
