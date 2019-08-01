package com.codeclan.example.BookingSystem.components;


import com.codeclan.example.BookingSystem.models.Booking;
import com.codeclan.example.BookingSystem.models.Course;
import com.codeclan.example.BookingSystem.models.Customer;
import com.codeclan.example.BookingSystem.repositories.BookingRepository.BookingRepository;
import com.codeclan.example.BookingSystem.repositories.CourseRepository.CourseRepository;
import com.codeclan.example.BookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {
        Course course1 = new Course("Introduction to Java", "Glasgow", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Ruby", "Edinburgh", 4);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Grace", "Glasgow", 25);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Daisy", "Edinburgh", 22);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("6 August 2019", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("15 August 2019", course1, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("23 Jun 2012", course2, customer2);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("31 Jan 2020", course1, customer2);
        bookingRepository.save(booking4);

        List<Course> rating = courseRepository.findCoursesByRating(5);

        List<Customer> coursesFound = customerRepository.findAllCustomersByCourse("Ruby");

        List<Course> found = courseRepository.findAllCoursesByName("Daisy");

        List<Booking> bookingByDate = bookingRepository.findBookingsByDate("31 Jan 2020");

    }


}
