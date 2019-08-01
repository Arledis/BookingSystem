package com.codeclan.example.BookingSystem.repositories.CourseRepository;

import com.codeclan.example.BookingSystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom{

    List<Course> findAllCoursesByName(String name);
}
