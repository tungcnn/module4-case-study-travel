package com.travel.service.flight.impl;

import com.travel.model.flight.FlightBrand;
import com.travel.repository.flight.IFlightBrandRepository;
import com.travel.service.flight.serviceinterface.IFlightBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlightBrandServiceImpl implements IFlightBrandService {
    @Autowired
    private IFlightBrandRepository flightBrandRepository;

    @Override
    public Page<FlightBrand> findAll(Pageable pageable) {
        return flightBrandRepository.findAll(pageable);
    }

    @Override
    public FlightBrand findById(long id) {
        return flightBrandRepository.findById(id).get();
    }

    @Override
    public void save(FlightBrand flightBrand) {
        flightBrandRepository.save(flightBrand);
    }

    @Override
    public void delete(long id) {
        flightBrandRepository.deleteById(id);
    }
}
