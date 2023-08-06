package net.javaguides.usermanagement.model;

/**
 * User.java This is a model class represents a User entity
 * 
 * @author Ramesh Fadatare
 *
 */
public class User {
	protected int id;
	public User(int id, String firstName, String lastName, String city, String dateOfBirth) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		City = city;
		DateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected String FirstName;
	protected String LastName;
	protected String City;
	protected String DateOfBirth;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public User(String firstName, String lastName, String city, String dateOfBirth) {
		super();
		FirstName = firstName;
		LastName = lastName;
		City = city;
		DateOfBirth = dateOfBirth;
	}
}
