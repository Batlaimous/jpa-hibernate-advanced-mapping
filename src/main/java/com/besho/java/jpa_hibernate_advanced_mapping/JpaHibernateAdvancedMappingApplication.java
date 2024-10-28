package com.besho.java.jpa_hibernate_advanced_mapping;

import com.besho.java.jpa_hibernate_advanced_mapping.dao.AppDAO;
import com.besho.java.jpa_hibernate_advanced_mapping.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.text.html.parser.Entity;
import java.util.List;

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
			/*createInstructorWithCourses(appDAO);*/
			/*findInstructorWithCourses(appDAO);*/
			/*findCoursesForInstructor(appDAO);*/
			/*findInstructorJoinFetch(appDAO);*/
			/*updateInstructor(appDAO);*/
			/*updateTheCourse(appDAO);*/
			/*deleteTheInstructor(appDAO);*/
//			deleteTheCourseById(appDAO);
			//createCourseAndReviews(appDAO);
			/*findCourseWithReviews(appDAO);
			deleteCourseAndReviews(appDAO);*/
			/*createCourseAndStudents(appDAO);*/
			/*findCourseAndStudents(appDAO);*/
			findStudentAndCourses(appDAO);
	};
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int studentId = 1;
		Student student = appDAO.findStudentById(studentId);
		System.out.println( "Loaded Student is " + student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int courseId = 10;
		Course course = appDAO.findCourseAndStudentById(courseId);
		System.out.println( "Loaded Course is below   " + "\n" + course);
		System.out.println(course.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		// create a course
		Course course = new Course("Many-To-Many Relation mapping");

		// create the students
		Student tempStudent1 = new Student("John","Doe","jdoe@gmail.com");
		Student tempStudent2 = new Student("Mary","public","mpublic@gmail.com");
		Student tempStudent3 = new Student("Suzan","mounir","smounir@gmail.com");
		// add students to the course
course.addStudent(tempStudent1);
course.addStudent(tempStudent2);
		// save the course and students
		appDAO.save(course);
		System.out.println(course);
		System.out.println("Saved Succefully!!!!!!!!!!          ......................");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int courseId = 10;
		System.out.println("Deleting course " + courseId);
		appDAO.deleteCourseById(courseId);
		System.out.println("Deleted course succefully " + courseId);
	}

	private void findCourseWithReviews(AppDAO appDAO) {
		// get the course and reviews
		int courseId = 10;
		Course tempCourse = appDAO.findCourseWithReviewsById(courseId);
		// print the course
		System.out.println(tempCourse);
		// print the reviews
		System.out.println(tempCourse.getReviews());

	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course course = new Course("Pacman - How to Score One million Points");
		// add some reviews
		course.addReview(new Review("Greate course my friend go on we need more courses"));
		course.addReview(new Review("Cooooool Course"));
		course.addReview(new Review("What a dumb course this is not good"));
		course.addReview(new Review("this course is very usefull thank for everything"));

		// save the course
		System.out.println("Saving the course ");
		System.out.println(course);
		System.out.println("Saving the reviews ");
		System.out.println(course.getReviews());
		appDAO.save(course);
	}

	private void deleteTheCourseById(AppDAO appDAO) {
		int courseId = 11;
		System.out.println("Finding the Course by id: " + courseId + "To Delete !!!!!!!!!");
		appDAO.deleteCourseById(courseId);
		System.out.println( "The Course Deleted succefully");
	}

	private void deleteTheInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Finding the Instructor by id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println( "The Instructor Deleted succefully");
	}

	private void updateTheCourse(AppDAO appDAO) {
		int courseId = 12;
		System.out.println("Finding the Course by id: " + courseId);
		Course course = appDAO.findCourseById(courseId);
		System.out.println( "Updating this course: " + course);
		course.setTitle("Updated Title");
		appDAO.updateCourse(course);
		System.out.println( "The New Title For the Course is :  " + course.getTitle());
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Finding instructor with id " + theId);
		Instructor instructor = appDAO.getInstructor(theId);
		System.out.println("Updating ...... the istructor  " + instructor);
		instructor.setLastName("Test");
		appDAO.update(instructor);
		System.out.println("DONE DONE DONE DONE DONE DONE");
	}

	private void findInstructorJoinFetch(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor with id " + theId);
		Instructor tempInstructorJoin = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println(tempInstructorJoin);
		System.out.println("The Courses for " + tempInstructorJoin.getFirstName() + " are as following " + tempInstructorJoin.getCourses());
		System.out.println("DONE DONE DONE DONE DONE DONE ya sextooouuuuuuuu");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Finding Instructor id: " + theId);
		Instructor tempInstructor = appDAO.getInstructor(theId);
		System.out.println( " the Instructor "+ tempInstructor);
		// find courses for instructor
		System.out.println("Finding courses for uinstructor Id:   " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println( " the courses: "+ tempInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Instructor id: " + theId);
		Instructor tempInstructor = appDAO.getInstructor(theId);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourses());
		System.out.println("DONE DONE");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("batlaimous","King","batlaimous@gmail.com");
		InstructorDetail tempInstuctorDetail =
				new InstructorDetail("http://www.kingofjava.com/youtube","Cooooding");
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstuctorDetail);
		// create some courses
		/*Course	tempCourse1 = new Course("Air Guitar - The Ultimate Guid");
		Course	tempCourse2 = new Course("Portuguese - For Beginners");*/
		Course	tempCourse3 = new Course("The Ultimate DevOps Bootcamp");
		Course	tempCourse4 = new Course("The Complete JavaScript Course 2024");
		Course	tempCourse5 = new Course("Spring Boot 3, Spring 6 & Hibernate for Beginners");
		// save the instrructor
		// NOTE: this will Also save the courses because of Cascade Type.PRESIST
		tempInstructor.addCourse(tempCourse3);
		tempInstructor.addCourse(tempCourse4);
		tempInstructor.addCourse(tempCourse5);
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
		InstructorDetail tempInstuctorDetail = new InstructorDetail("http://www.cece.com/youtube","playing guitar");
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstuctorDetail);
		// save the instructor
		// NOTE: this will Also save the details object because of CascadeType.All annotation
		System.out.println("Saving instructor" + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("doneeee");
	}
}
