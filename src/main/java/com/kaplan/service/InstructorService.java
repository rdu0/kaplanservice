package com.kaplan.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaplan.model.Instructor;
import com.kaplan.repository.InstructorRepository;


@Service
public class InstructorService {
	@Autowired
	private InstructorRepository instructorRepository;
	
	private static List<Instructor> instructors = new ArrayList<>();
	private static int instructorCount;
	
	public InstructorService(){
		instructors.add(new Instructor(1, "Jimmy", "Fim", 3) );
		instructors.add(new Instructor(2, "Jack", "SS", 1));
		instructors.add(new Instructor(3, "Jill", "Mewe", 2));
		instructors.add(new Instructor(4, "Kae", " Wfm", 4));
		instructorCount=instructors.size();
	}
	
	public List<Instructor> retrieveInstructors() {
		return instructors;
	}

	public Instructor retrieveInstructor(int id) {
		for (Instructor instructor : instructors) {
			if (instructor.getId() == id)
				return instructor;
		}
		return null;
	}

	public Instructor addInstructor(String firstname, String lastname, int departmentId) {
		Instructor instructor = new Instructor(++instructorCount, firstname, lastname, departmentId);
		instructors.add(instructor);
		instructorRepository.save(instructor);
		return instructor;
	}

	public Instructor update(Instructor instructor) {
		if (instructor==null ) {return null;}
		Instructor foundInstructor = retrieveInstructor(instructor.getId());
		foundInstructor.setFirstName(instructor.getFirstName());
		foundInstructor.setLastName(instructor.getLastName());
		foundInstructor.setDepartmentId(instructor.getDepartmentId());

		return foundInstructor;
	}

	public Instructor deleteById(int id) {
		Instructor instructor = retrieveInstructor(id);
		if (instructor == null)
			throw new RuntimeException("instructor not found");
		if (instructors.remove(instructor)) {
			return instructor;
		}
		throw new RuntimeException("Delete Unsuccessful");
	}
	
}
