package com.besho.java.jpa_hibernate_advanced_mapping.dao;

import com.besho.java.jpa_hibernate_advanced_mapping.entity.Course;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.Instructor;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

// define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor getInstructor(int theId) {
       return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public Instructor deleteById(int theId) {
        Instructor theInstructor = getInstructor(theId);
        entityManager.remove(theInstructor);
        return theInstructor;
    }

    @Override
    public InstructorDetail getInstructorDetail(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public InstructorDetail deleteInstructorDetail(int theId) {
        InstructorDetail theInstructorDetail = getInstructorDetail(theId);
        theInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(theInstructorDetail);
        return theInstructorDetail;
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);
        // execute the query
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        // create a query with join
        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i from Instructor i "
                        + "JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail "
                        + "where i.id = :data", Instructor.class);
        query.setParameter("data", theId);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void updateCourse(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor theInstructor = entityManager.find(Instructor.class, theId);
        // get hte courses
        List<Course> courses = theInstructor.getCourses();
        // breack association of all courses
        for (Course course : courses) {
            course.setInstructor(null);
        }

        // delete the instructor
        entityManager.remove(theInstructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course theCourse = entityManager.find(Course.class, theId);

        entityManager.remove(theCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseWithReviewsById(int theId) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT i from Course i "
                + "JOIN FETCH i.reviews "
                + "where i.id = :data", Course.class
        );
        query.setParameter("data", theId);

        // execute the query
        Course course = query.getSingleResult();

        return course;
    }


}
