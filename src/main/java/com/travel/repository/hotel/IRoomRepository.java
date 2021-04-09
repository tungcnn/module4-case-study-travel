package com.travel.repository.hotel;

import com.travel.model.hotel.Room;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoomRepository extends PagingAndSortingRepository<Room, Long> {
}