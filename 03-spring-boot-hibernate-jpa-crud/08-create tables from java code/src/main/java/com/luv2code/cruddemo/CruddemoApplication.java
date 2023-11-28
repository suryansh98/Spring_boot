package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudent(studentDAO);

			//queryForLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all entries in the database");

		int rowsRemoved = studentDAO.deleteAll();

		System.out.println("Total number of enteries removed: " + rowsRemoved);
	}

	private void deleteStudent(StudentDAO studentDAO)
	{
		int studentId = 2;

		System.out.println("Deleting student with ID: " + studentId);

		studentDAO.delete(studentId);
	}



	private void updateStudent(StudentDAO studentDAO)
	{
		//retrieve student based on the id
		int studentId = 1;
		System.out.println("Getting the student with ID:" + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		//update student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: " + studentDAO.findById(studentId));
	}


	private void queryForLastName(StudentDAO studentDAO)
	{
		List<Student> theStudents = studentDAO.findByLastName("Uzumaki");

		for(Student s: theStudents)
			System.out.println(s);
	}



	private void queryForStudent(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display the list
		for(Student tempStudent: theStudents)
		System.out.println(tempStudent);


	}


	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating a new student");
		Student teampStudent = new Student("Naruto", "Uzumaki", "nu@outlook.com");

		//save the student
		studentDAO.save(teampStudent);

		//display the id of the saved student
		System.out.println("Id of the saved student: " + teampStudent.getId());

		//retrieve student based on the id: primary Key
		System.out.println("Retrieving the student with id:" + teampStudent.getId());
		Student tempStudent1 =  studentDAO.findById(teampStudent.getId());

		//display student
		System.out.println("Found the student:" + tempStudent1.toString());


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
