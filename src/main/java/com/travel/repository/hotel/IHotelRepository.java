package com.travel.repository.hotel;

import com.travel.model.hotel.Hotel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IHotelRepository extends PagingAndSortingRepository<Hotel, Long> {
}
