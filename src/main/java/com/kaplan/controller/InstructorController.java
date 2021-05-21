package com.kaplan.controller;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import com.kaplan.model.Instructor;
import com.kaplan.repository.InstructorRepository;
import com.kaplan.repository.InstructorRepositoryImpl;
import com.kaplan.service.InstructorService;

@RestController
//@RequestMapping("/api")
public class InstructorController {
	@Autowired
	private InstructorService instructorService;

	
	@GetMapping("/instructors")
	public List<Instructor> retrieveInstructos() {
		return instructorService.retrieveInstructors();
	}

	@GetMapping(path = "/instructors/{id}")
	public Instructor retrieveInstructor(@PathVariable int  id) {
		return instructorService.retrieveInstructor(id);
	}

	@DeleteMapping("/instructors/{id}")
	public ResponseEntity<Instructor> deleteInstructor(@PathVariable int id) {
		Instructor instructor = instructorService.deleteById(id);
		System.out.println(instructor);
		if (instructor != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/instructors/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable int id, @RequestBody Instructor instructor) {
		System.out.println(instructor);
		instructorService.update(instructor);
		return new ResponseEntity<Instructor>(instructor, HttpStatus.OK);
	}

	@PostMapping("/instructors")
	ResponseEntity<?> add(@RequestBody Instructor instructor) {
		Instructor newInstructor = instructorService.addInstructor(instructor.getFirstName(),instructor.getLastName(),instructor.getDepartmentId());
		if (newInstructor == null) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<Instructor>(newInstructor, HttpStatus.OK);
	}
	
}
