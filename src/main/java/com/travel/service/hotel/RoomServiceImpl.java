package com.travel.service.hotel;

import com.travel.model.hotel.Room;
import com.travel.repository.hotel.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomRepository roomRepository;


    @Override
    public Page<Room> findAll(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    @Override
    public Room findById(long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void delete(long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Page<Room> findAllByTypeContaining(String type, Pageable pageable) {
        return roomRepository.findAllByTypeContaining(type, pageable);
    }

    @Override
    public Iterable<Room> findAllByLocationOrName(String location_hotel, String name_hotel, int departure, int limit, int offset) {
        return roomRepository.findAllByLocationOrName(location_hotel,name_hotel,departure,limit,offset);
    }
}
