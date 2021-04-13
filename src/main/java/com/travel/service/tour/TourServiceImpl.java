package com.travel.service.tour;

import com.travel.model.tour.Tour;
import com.travel.repository.tour.ITourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements ITourService {
    private final ITourRepository tourRepository;

    @Autowired
    public TourServiceImpl(ITourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public Iterable<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public Tour findById(long id) {
        return tourRepository.findById(id).get();
    }

    @Override
    public void save(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public void delete(long id) {
        tourRepository.deleteById(id);
    }
}
