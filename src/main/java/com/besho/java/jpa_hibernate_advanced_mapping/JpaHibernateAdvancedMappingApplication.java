package com.besho.java.jpa_hibernate_advanced_mapping;

import com.besho.java.jpa_hibernate_advanced_mapping.dao.AppDAO;
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
			deleteInstructorDetail(appDAO);

	};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Be Ready We Are Deleting the IbnstructorDetail with Id : "  + theId);
		InstructorDetail tempInstructorDetail = appDAO.deleteInstructorDetail(theId);
		System.out.println(tempInstructorDetail);
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
		Instructor tempInstructor = new Instructor("Giovanni","Agusto","giovanni@gmail.com");

		InstructorDetail tempInstuctorDetail =
				new InstructorDetail("http://www.gigi.com/youtube","sleeping");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstuctorDetail);

		// save the instructor
		// NOTE: this will Also save the details object because of CascadeType.All annotation
		System.out.println("Saving instructor" + tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("doneeee");
	}

}
