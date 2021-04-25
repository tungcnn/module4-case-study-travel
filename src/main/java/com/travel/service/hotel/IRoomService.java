package com.travel.service.hotel;

import com.travel.model.hotel.Room;
import com.travel.service.IGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRoomService extends IGeneral<Room> {
    Page<Room> findAllByTypeContaining(String type, Pageable pageable);
}
