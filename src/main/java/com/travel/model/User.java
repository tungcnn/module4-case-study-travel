package com.travel.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private boolean disable = false;

    @NotNull
    @Size(max = 55, message = "Điền tên mày vào không thằng Tùng bắn á")
    private String name;

    @Email(message = "Nhập Email không thằng Tùng bắn á")
    @NotNull
    private String email;

    @NotNull(message = "Cho tao số điện thoại không thằng Tùng bắn á")
    private String phoneNumber;

    @NotNull(message = "Nhập CCCD/Passport không thằng Tùng bắn á")
    private String idPapers;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
