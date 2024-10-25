package com.besho.java.jpa_hibernate_advanced_mapping;

import com.besho.java.jpa_hibernate_advanced_mapping.dao.AppDAO;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.Course;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.Instructor;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaHibernateAdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateAdvancedMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
				/*createInstructor(appDAO);*/
			/*getInstructor(appDAO);*/
			/*deleteInstructor(appDAO);*/
			/*getInstructorDetail(appDAO);*/
			/*deleteInstructorDetail(appDAO);*/
			createInstructorWithCourses(appDAO);

	};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Mariana","Emad","mariana@gmail.com");

		InstructorDetail tempInstuctorDetail =
				new InstructorDetail("http://www.mariana.com/youtube","Swimming");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstuctorDetail);

		// create some courses
		Course	tempCourse1 = new Course("Air Guitar - The Ultimate Guid");
		Course	tempCourse2 = new Course("Portuguese - For Beginners");
		/*Course	tempCourse3 = new Course("The Ultimate DevOps Bootcamp");
		Course	tempCourse4 = new Course("The Complete JavaScript Course 2024");
		Course	tempCourse5 = new Course("Spring Boot 3, Spring 6 & Hibernate for Beginners");*/

		// save the instrructor
		// NOTE: this will Also save the courses because of Cascade Type.PRESIST
tempInstructor.addCourse(tempCourse1);
tempInstructor.addCourse(tempCourse2);

		System.out.println("Saving the instructor :" + tempInstructor);
		System.out.println("Saving the instructor :" + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Be Ready We Are Deleting the IbnstructorDetail with Id : "  + theId);
		InstructorDetail tempInstructorDetail = appDAO.deleteInstructorDetail(theId);
		System.out.println(tempInstructorDetail);
		System.out.println("DONE DONE DONE DONE DONE DONE DONE");
	}

	private void getInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("finding the instructorDetail where ID = " + theId);
		InstructorDetail tempInstructorDetail = appDAO.getInstructorDetail(theId);
		System.out.println( "tempinstructorDetail is " +tempInstructorDetail);
		System.out.println("the Associated instructor : " + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting the instructor with id: " +theId);
		Instructor tempInstructor =  appDAO.deleteById(theId);
		System.out.println("the Instructor deleted : " +tempInstructor);
	}

	private void getInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("finding the instructor where ID = " + theId);
		Instructor tempInstructor = appDAO.getInstructor(theId);
		System.out.println( "tempinstructor is " +tempInstructor);
		System.out.println("the Associated instructor details : " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*// create the instructor
		Instructor tempInstructor = new Instructor("Beshoy","Younan","besho@gmail.com");

		InstructorDetail tempInstuctorDetail =
				new InstructorDetail("http://www.beshoyounan.com/youtube","i love to code");
*/
		// create the instructor
		Instructor tempInstructor = new Instructor("Cecelia","Fernando","cecelia@gmail.com");

		InstructorDetail tempInstuctorDetail =
				new InstructorDetail("http://www.cece.com/youtube","playing guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstuctorDetail);

		// save the instructor
		// NOTE: this will Also save the details object because of CascadeType.All annotation
		System.out.println("Saving instructor" + tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("doneeee");
	}

}
