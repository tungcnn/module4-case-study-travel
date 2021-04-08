package com.travel.service.tour;

import com.travel.model.tour.Tour;
import com.travel.repository.tour.ITourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements ITourService {
    @Autowired
    private ITourRepository tourRepository;

    @Override
    public Iterable<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public Tour findById(long id) {
        return tourRepository.findOne(id);
    }

    @Override
    public void save(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public void delete(long id) {
        tourRepository.delete(id);
    }
}
