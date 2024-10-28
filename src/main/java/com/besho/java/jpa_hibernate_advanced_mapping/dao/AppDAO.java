package com.besho.java.jpa_hibernate_advanced_mapping.dao;

import com.besho.java.jpa_hibernate_advanced_mapping.entity.Course;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.Instructor;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.InstructorDetail;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor getInstructor(int theId);
    Instructor deleteById(int theId);

    InstructorDetail getInstructorDetail(int theId);

    InstructorDetail deleteInstructorDetail(int theId);

    List<Course> findCoursesByInstructorId(int theId);
   Instructor findInstructorByIdJoinFetch(int theId);

   void update(Instructor theInstructor);

   Course findCourseById(int theId);
    void updateCourse(Course theCourse);
    void deleteInstructorById(int theId);
    void deleteCourseById(int theId);
    void save(Course theCourse);
    Course findCourseWithReviewsById(int theId);
    Course findCourseAndStudentById(int theId);
    Student findStudentById(int theId);
    void update(Student theStudent);


}
