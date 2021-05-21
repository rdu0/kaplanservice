package com.kaplan.repository;

import com.kaplan.model.Instructor;

public interface InstructorRepository {
	public void save() ;
	public void save(Instructor instructor) ;
}
