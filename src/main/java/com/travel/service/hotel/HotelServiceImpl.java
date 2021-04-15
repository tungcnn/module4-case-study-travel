package com.travel.service.hotel;

import com.travel.model.hotel.Hotel;
import com.travel.repository.hotel.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public Iterable<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Hotel findById(long id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void delete(long id) {
        hotelRepository.deleteById(id);
    }
}
