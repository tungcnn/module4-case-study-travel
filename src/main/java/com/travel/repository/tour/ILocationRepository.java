package com.travel.repository.tour;

import com.travel.model.tour.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ILocationRepository extends CrudRepository<Location, Long> {
}
