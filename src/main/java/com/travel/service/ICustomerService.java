package com.travel.service;

import com.travel.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id);
    void save(Customer customer);
    void delete(Long id);
}
