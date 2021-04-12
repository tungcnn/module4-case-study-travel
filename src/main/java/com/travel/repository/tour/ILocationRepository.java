package com.travel.repository.tour;

import com.travel.model.tour.Location;
import org.springframework.data.repository.CrudRepository;

public interface ILocationRepository extends CrudRepository<Location, Long> {
}
