package com.travel.repository.tour;

import com.travel.model.tour.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ITourRepository extends JpaRepository<Tour, Long> {
    Page<Tour> findByNameContaining(String name, Pageable pageable);

//    @Query(value = "CALL fillAll(?1,?2, ?3, ?4)", nativeQuery = true)
    Page<Tour> findAllByNameOrDescriptionOrPriceOrTime(String name,String description, Double price, String time, Pageable pageable);
}
