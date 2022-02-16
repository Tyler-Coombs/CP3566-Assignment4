package com.example.assignment4;

import org.springframework.data.repository.CrudRepository;
import com.example.assignment4.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    Course findCourseByCourseID(Integer courseID);
}
