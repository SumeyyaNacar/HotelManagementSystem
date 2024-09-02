package com.hotel.service;

import com.hotel.domain.Room;
import com.hotel.dto.RoomDTO;
import com.hotel.exception.RoomNotFoundException;
import com.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    //save a room
    public void saveRoom(Room room) {
        repository.save(room);
    }

    //get all rooms
    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    //get room by id
    public Room getRoomById(Long id) {
        Room foundRoom = repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException("Room is not found by ID: " + id));
        return foundRoom;
    }

    public void updateById(Long id, RoomDTO roomDTO) {
        Room existingRoom = getRoomById(id);//room db den getirildi

        //dtodan gelen bilgiler ile asil obje guncelleyenecek
        existingRoom.setRoomNumber(roomDTO.getRoomNumber());
        existingRoom.setRoomType(roomDTO.getRoomType());

        //guncelleme icin
        repository.save(existingRoom);
    }

    public void deleteRoomById(Long id) {
        Room room = getRoomById(id);
        repository.delete(room);

    }
}
