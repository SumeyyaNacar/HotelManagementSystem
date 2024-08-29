package com.hotel.service;

import com.hotel.domain.Room;
import com.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository ;

    //save a room
    public void saveRoom(Room room) {
        repository.save(room);
    }
}
