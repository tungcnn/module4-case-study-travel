package com.travel.repository.hotel;

import com.travel.model.hotel.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Long> {
    Page<Room> findAllByTypeContaining(String type, Pageable pageable);
}
