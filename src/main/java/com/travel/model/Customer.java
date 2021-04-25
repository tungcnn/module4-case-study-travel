package com.travel.model;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @Nullable
    private User user;
    private String name;
    private String Email;
    private String phoneNumber;
    private String idPapers;
}
