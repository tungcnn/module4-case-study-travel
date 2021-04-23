package com.travel.repository.hotel;

import com.travel.model.hotel.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoomRepository extends JpaRepository<Room, Long> {
    Page<Room> findAllByTypeContaining(String type, Pageable pageable);

    @Query(value = "call findAllByLocationOrName(?1,?2,?3,?4,?5)", nativeQuery = true)
    Iterable<Room> findAllByLocationOrName (String location_hotel, String name_hotel,int departure, int limit, int offset);}
