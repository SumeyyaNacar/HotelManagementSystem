package com.hotel.controller;

import com.hotel.domain.Room;
import com.hotel.dto.RoomDTO;
import com.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hotels/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;//field inj

    //CREATE
    //1-save a room & return message--CREATED
    //request : http://localhost:8080/hotels/rooms + POST +json format body
    //responce : basarili + http status code(CREATED)
    //ayni url ile post, delete, update
    @PostMapping
    public ResponseEntity<String> saveRoom(@Valid @RequestBody Room room){
        roomService.saveRoom(room);
        return new ResponseEntity<>("Oda basariyla kaydedildi", HttpStatus.CREATED);
    }

    //READ
    //2-Get all rooms, return : List<Room>
    //http://localhost8080/hotels/hotels/rooms + GET +HTTP.OK
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    //3-Get a room by Id,return : Room
    //http://localhost:8080/hotels/rooms/2
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id){
        Room getRoom = roomService.getRoomById(id);
        return new ResponseEntity<>(getRoom,HttpStatus.OK);
        //return ResponseEntity.ok(getRoom);

    }

    //UPDATE
    //4- Update a Room with Using DTO, return String bir ifade olsun
    //dto ile ana obje korunur
    //http://localhost:8080/hotels/rooms/update?id +POST
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRoomById(@PathVariable("id") Long id, @Valid @RequestBody RoomDTO roomDTO){
        roomService.updateById(id,roomDTO);
        return ResponseEntity.ok("Room is updated successfully!");
    }
    //DELETE
    //5- delete a room by ID,return:Message
    //http://localhost:8080/hotels/rooms/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoomById(@PathVariable("id") Long id){
        roomService.deleteRoomById(id);
        return ResponseEntity.ok("Room is deleted successfully!");


    }









}
