package com.hotel.service;

import com.hotel.domain.Reservation;
import com.hotel.dto.ReservationDTO;
import com.hotel.exception.ConflictException;
import com.hotel.exception.ReservationNotFoundException;
import com.hotel.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    //save
    public void saveReservation(Reservation reservation) {
        if (reservationRepository.existsById(reservation.getId())){
            throw new ConflictException("Id already exists!");
        }
        reservationRepository.save(reservation);
    }

    //get all reservations
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }


    //get all reservation by page
    public Page<Reservation> getAllReservationsByPage(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    public Reservation getReservationById(Long id) {
        Reservation reservation =
                reservationRepository.findById(id).orElseThrow(()->new ReservationNotFoundException("Reservation not found"));
        return reservation;
    }

    public void deleteReservationById(Long id) {
        //idsi verilen reservationi getir
        Reservation foundReservation = getReservationById(id);
        reservationRepository.delete(foundReservation);
    }

    public void updateReservationById(Long id, ReservationDTO reservationDTO) {
        //guncellenecek reservasyon getirildi
        Reservation foundReservation = getReservationById(id);

        //guncelleme
        foundReservation.setRoom(reservationDTO.getRoom());
        foundReservation.setGuest(reservationDTO.getGuest());
        foundReservation.setEnteranceDate(reservationDTO.getEnteranceDate());
        foundReservation.setExistDate(reservationDTO.getExistDate());

        reservationRepository.save(foundReservation);
    }
}
