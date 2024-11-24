package com.foreverchild.spring_hibernate_jpa_project;

import com.foreverchild.spring_hibernate_jpa_project.dao.StudentDao;
import com.foreverchild.spring_hibernate_jpa_project.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateJpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateJpaProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(StudentDao studentDao){
		return runner -> {

//			System.out.println("creating student");
//			Student student = new Student("harrison","ogbonnaya","harrison@gmail.com");
//			System.out.println("saving student");
//			studentDao.saveStudent(student);
//			System.out.println("saved student: "+student.getId());

			getStudentById(studentDao);
			getAllStudents(studentDao);
			getStudentsByLastName(studentDao);
			updateStudent(studentDao);
			deleteStudent(studentDao);
			deleteAllStudent(studentDao);
		};

	}

	private void deleteAllStudent(StudentDao studentDao) {
		studentDao.deleteAll();
	}

	private void deleteStudent(StudentDao studentDao) {
		studentDao.delete(3);
		System.out.println("Deleting a student");
	}

	private void updateStudent(StudentDao studentDao) {
		Student foundStudent = studentDao.findById(2);
		foundStudent.setFirstName("Fred");
		studentDao.update(foundStudent);
		System.out.println("Updated student with Lastname fred: "+foundStudent);

	}

	private void getStudentsByLastName(StudentDao studentDao) {
		List<Student>students = studentDao.findByLastName("ogbonnaya");
		System.out.println("students with Lastname: "+students);
	}

	private void getAllStudents(StudentDao studentDao) {
		List<Student> students = studentDao.findAll();
//		System.out.println("All students :"+students);
		for (Student s:students){
			System.out.println("Students :"+s);
		}
	}

	private void getStudentById(StudentDao studentDao) {
		Student myStudent = studentDao.findById(2);
		System.out.println("Found student: "+ myStudent);
	}

}
