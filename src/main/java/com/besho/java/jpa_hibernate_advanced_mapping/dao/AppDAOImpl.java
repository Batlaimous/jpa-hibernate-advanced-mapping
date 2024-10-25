package com.besho.java.jpa_hibernate_advanced_mapping.dao;

import com.besho.java.jpa_hibernate_advanced_mapping.entity.Instructor;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
