package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createMultipleStudents(studentDAO);

		};
	}

	private void createMultipleStudents(StudentDAO studentDAO)
	{
		//create multiple students
		System.out.println("Create 3 student objects...");
		Student tempStudent1 = new Student("Riko", "Mushashi", "paul@gmail.com");
		Student tempStudent2 = new Student("Linda", "Sheldon", "paul@gmail.com");
		Student tempStudent3 = new Student("John", "Kelly", "john@gmail.com");

		//save the student objects
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


	private void createStudent(StudentDAO studentDAO) {

		//create student object
		System.out.println("Create student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		System.out.println("Saved student. Generated Id:" + tempStudent.getId());
	}

}
