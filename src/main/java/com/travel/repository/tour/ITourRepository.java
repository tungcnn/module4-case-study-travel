package com.travel.repository.tour;

import com.travel.model.tour.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITourRepository extends JpaRepository<Tour,Long> {
}
