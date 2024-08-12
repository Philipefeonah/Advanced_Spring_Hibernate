package com.maxiflexy.advancedhibernate;

import com.maxiflexy.advancedhibernate.dao.AppDAO;
import com.maxiflexy.advancedhibernate.entity.Instructor;
import com.maxiflexy.advancedhibernate.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void createInstructor(AppDAO appDAO) {

//		// create the instructor
//		Instructor tempInstructor = new Instructor("Maxi", "Kachi", "onyekachimaximiilian@gmail.com");
//
//		// create the instructor detail
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.maxiflexy/youtube", "football");
//
//		// associate the objects
//		tempInstructor.setInstructorDetail(tempInstructorDetail);
//
//		// save the instructor
//		// Note: this will also save the details object because of CascadeType.ALL
//		System.out.println("Saving instructor: " + tempInstructor);
//		appDAO.save(tempInstructor);


		// create the instructor
		Instructor tempInstructor = new Instructor("Capacity", "Dominic", "onyemax247@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.maxiflexy/youtube", "Music");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// Note: this will also save the details object because of CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
	}
}
