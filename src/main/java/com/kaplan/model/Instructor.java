package com.kaplan.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
	@Column(name = "id")
	private int id;

	private String firstName;

	private String lastName;

	@Column(name = "department_id")
	private int departmentId;

	public Instructor() {}
	
	public Instructor(String firstName, String lastName, int departmentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
	}

	public Instructor(int id, String firstName, String lastName, int departmentId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Instructor that = (Instructor) o;
		return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName);
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", departmentId="
				+ departmentId + "]";
	}
	

}
