package com.hotel.controller;

import com.hotel.domain.Room;
import com.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;//field inj

    //CREATE
    //1-save a room & return message--CREATED
    //request : http://localhost:8080/rooms + POST +json format body
    //responce : basarili + http status code(CREATED)
    //ayni url ile post, delete, update
    @PostMapping
    public ResponseEntity<String> saveRoom(@Valid @RequestBody Room room){
        roomService.saveRoom(room);
        return new ResponseEntity<>("Oda basariyla kaydedildi", HttpStatus.CREATED);
    }



}
