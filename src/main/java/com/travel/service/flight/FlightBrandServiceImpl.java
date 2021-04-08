package com.travel.service.flight;

import com.travel.model.flight.FlightBrand;
import com.travel.repository.flight.IFlightBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightBrandServiceImpl implements IFlightBrandService{
    @Autowired
    private IFlightBrandRepository flightBrandRepository;

    @Override
    public Iterable<FlightBrand> findAll() {
        return flightBrandRepository.findAll();
    }

    @Override
    public FlightBrand findById(long id) {
        return flightBrandRepository.findOne(id);
    }

    @Override
    public void save(FlightBrand flightBrand) {
        flightBrandRepository.save(flightBrand);
    }

    @Override
    public void delete(long id) {
        flightBrandRepository.delete(id);
    }
}
