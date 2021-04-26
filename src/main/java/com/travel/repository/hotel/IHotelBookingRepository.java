package com.travel.repository.hotel;

import com.travel.model.hotel.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelBookingRepository extends JpaRepository<HotelBooking, Long> {
}
