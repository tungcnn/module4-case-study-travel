package com.travel.repository.tour;

import com.travel.model.tour.Tour;
import org.springframework.data.repository.CrudRepository;

public interface ITourRepository extends CrudRepository<Tour,Long> {
}
