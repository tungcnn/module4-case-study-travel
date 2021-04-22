package com.travel.service.hotel;

import com.travel.model.hotel.HotelBooking;
import com.travel.repository.hotel.IHotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HotelBookingServiceIpml implements IHotelBookingService{

    @Autowired
    private IHotelBookingRepository hotelBookingRepository;

    @Override
    public Page<HotelBooking> findAll(Pageable pageable) {
        return hotelBookingRepository.findAll(pageable);
    }

    @Override
    public HotelBooking findById(long id) {
        return hotelBookingRepository.getOne(id);
    }

    @Override
    public void save(HotelBooking hotelBooking) {
        hotelBookingRepository.save(hotelBooking);
    }

    @Override
    public void delete(long id) {
        hotelBookingRepository.deleteById(id);
    }
}
