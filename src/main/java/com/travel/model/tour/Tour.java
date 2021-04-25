package com.travel.model.tour;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "tour")
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private String time;
    @ManyToOne
    private Location location;
}
