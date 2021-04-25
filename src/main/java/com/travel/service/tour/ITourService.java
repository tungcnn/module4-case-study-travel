package com.travel.service.tour;

import com.travel.model.tour.Tour;
import com.travel.service.IGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITourService extends IGeneral<Tour> {
    Page<Tour> findByName(String name, Pageable page);

    Page<Tour> findAllByNameByTimeByPrice(String name, String description, Double price, String time, Pageable pageable);
}
