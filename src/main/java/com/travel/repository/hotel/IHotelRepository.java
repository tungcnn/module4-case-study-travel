package com.travel.repository.hotel;

import com.travel.model.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelRepository extends JpaRepository<Hotel, Long> {
}
