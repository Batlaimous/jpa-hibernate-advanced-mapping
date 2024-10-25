package com.besho.java.jpa_hibernate_advanced_mapping.dao;

import com.besho.java.jpa_hibernate_advanced_mapping.entity.Instructor;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor getInstructor(int theId);
    Instructor deleteById(int theId);

    InstructorDetail getInstructorDetail(int theId);

    InstructorDetail deleteInstructorDetail(int theId);
}
