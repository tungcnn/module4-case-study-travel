package com.travel.model.tour;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "location")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
