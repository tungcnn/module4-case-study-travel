package com.travel.model.tour;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class BookTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String phone;
    private String address;
    @ManyToOne
    private Tour tour;
}
