package com.travel.model.hotel;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String location;
}
