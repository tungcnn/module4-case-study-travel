package com.travel.service.tour;

import com.travel.model.tour.BookTour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookTourService implements IBookTourService {
    @Autowired
    private IBookTourService bookTourService;

    @Override
    public Page<BookTour> findAll(Pageable pageable) {
        return bookTourService.findAll(pageable);
    }

    @Override
    public BookTour findById(long id) {
        return bookTourService.findById(id);
    }

    @Override
    public void save(BookTour bookTour) {
        bookTourService.save(bookTour);
    }

    @Override
    public void delete(long id) {

    }
}
