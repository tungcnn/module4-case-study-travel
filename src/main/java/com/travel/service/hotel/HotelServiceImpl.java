package com.travel.service.hotel;

import com.travel.model.hotel.Hotel;
import com.travel.repository.hotel.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        return hotelRepository.findAll(pageable);
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
