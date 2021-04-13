package com.travel.repository.tour;

import com.travel.model.tour.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepository extends JpaRepository<Location, Long> {
}
