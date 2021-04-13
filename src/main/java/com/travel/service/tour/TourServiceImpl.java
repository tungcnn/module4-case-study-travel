package com.travel.service.tour;

import com.travel.model.tour.Tour;
import com.travel.repository.tour.ITourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements ITourService {
    @Autowired
    private ITourRepository tourRepository;

    @Override
    public Page<Tour> findAll(Pageable pageable) {
        return tourRepository.findAll(pageable);
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
