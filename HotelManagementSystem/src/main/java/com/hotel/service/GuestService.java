package com.hotel.service;

import com.hotel.domain.Guest;
import com.hotel.dto.GuestDTO;
import com.hotel.exception.GuestNotFoundException;
import com.hotel.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return guestRepository.findById(id).orElseThrow(() -> new GuestNotFoundException("Guest is not found by id : " + id));
    }

    //update
    public void updateGuestById(Long id, GuestDTO guestDTO) {
        //guest i db cekme
        Guest foundGuest = getGuestById(id);
        foundGuest.setName(guestDTO.getName());
        foundGuest.setMedeniDurum(guestDTO.getMedeniDurum());
        guestRepository.save(foundGuest);

    }

    //delete
    public void deleteGuestById(Long id) {
        Guest foundGuest = getGuestById(id);
        guestRepository.delete(foundGuest);
    }


    //6-Get Guests with Page
    public Page<Guest> getAllGuestByPage(Pageable pageable) {
        return guestRepository.findAll(pageable);
    }
}
