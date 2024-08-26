package com.hotel.service;

import com.hotel.domain.Hotel;
import com.hotel.exception.HotelNotFoundException;
import com.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;//field inj

    //1-save a hotel
    public void saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }
    //2-Get all hotels
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    //3-Get a hotel by Id
    public Hotel getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()->new HotelNotFoundException("Hotel bulunamadi!"));
        return hotel;
    }

    //4- delete a hotel by ID
    public void deleteHotelById(Long id) {
       //Hotel hotel = getHotelById(id);
       //hotelRepository.deleteById(id);

        hotelRepository.deleteById(id);//getHotelById()
    }


}
