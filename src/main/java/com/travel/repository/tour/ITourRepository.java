package com.travel.repository.tour;

import com.travel.model.tour.Tour;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITourRepository extends PagingAndSortingRepository<Tour,Long> {
}
