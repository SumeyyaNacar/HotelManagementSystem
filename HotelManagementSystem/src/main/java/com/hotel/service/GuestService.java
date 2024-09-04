package com.hotel.service;

import com.hotel.domain.Guest;
import com.hotel.exception.GuestNotFoundException;
import com.hotel.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    //save a guest
    public void saveGuest(Guest guest) {
        guestRepository.save(guest);
    }

    //get all guests
    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    //get guest by id
    public Guest getGuestById(Long id) {
       return guestRepository.findById(id).orElseThrow(()->new GuestNotFoundException("Guest is not found by id : "+ id));
    }
}
