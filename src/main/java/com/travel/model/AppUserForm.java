package com.travel.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Data
public class AppUserForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true)
    private String password;

    private String firstName;

    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10,12})")
    private String phoneNumber;

    private String gender;

    private Date dob;

    @Transient
    private MultipartFile avatar;

    @ManyToOne
    private AppRole appRole;
}
