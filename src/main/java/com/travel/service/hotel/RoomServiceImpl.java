package com.travel.service.hotel;

import com.travel.model.hotel.Hotel;
import com.travel.model.hotel.Room;
import com.travel.repository.hotel.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomRepository roomRepository;


    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(long id) {
        return roomRepository.findOne(id);
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void delete(long id) {
        roomRepository.delete(id);
    }
}
