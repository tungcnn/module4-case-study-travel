package com.travel.service.tour;

import com.travel.model.tour.Location;
import com.travel.repository.tour.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(long id) {
        return locationRepository.findOne(id);
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void delete(long id) {
        locationRepository.delete(id);
    }
}
