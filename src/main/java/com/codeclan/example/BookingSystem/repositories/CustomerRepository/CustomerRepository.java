package com.codeclan.example.BookingSystem.repositories.CustomerRepository;

import com.codeclan.example.BookingSystem.models.Customer;
import com.codeclan.example.BookingSystem.repositories.CourseRepository.CourseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CourseRepositoryCustom {
    List<Customer> findAllCustomersByCourse(String name);
}
