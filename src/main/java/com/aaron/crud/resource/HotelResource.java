package com.aaron.crud.resource;

import java.util.List;
import java.util.Optional;
import com.aaron.crud.entity.Hotel;
import com.aaron.crud.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelResource {
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @GetMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.get();
    }

    @PostMapping("/hotels")
    public Hotel createHotel(@RequestBody Hotel hotel) {
        Hotel newHotel = hotelRepository.save(hotel);
        return newHotel;
    }

    @PutMapping("/hotels/{id}")
    public ResponseEntity<Object> updateHotel(@RequestBody Hotel hotelUpdated, @PathVariable long id) {

        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (!hotel.isPresent())
            return ResponseEntity.notFound().build();

        hotelUpdated.setId(id);
        hotelRepository.save(hotelUpdated);
        return ResponseEntity.ok().body(hotelUpdated);
    }

    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<Object> deleteHotel(@PathVariable long id) {
        hotelRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
