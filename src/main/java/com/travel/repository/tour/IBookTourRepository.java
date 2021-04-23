package com.travel.repository.tour;

import com.travel.model.tour.BookTour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookTourRepository extends JpaRepository<BookTour,Long> {
}
