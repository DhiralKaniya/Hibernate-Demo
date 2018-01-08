package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id @GeneratedValue
	private int id;
	private String studentName;
	private String studentAge;
	private String contactNo;
	
	public Student() {}
	public Student(String studentName, String studentAge, String contactNo) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.contactNo = contactNo;
	}
	public Student(int id, String studentName, String studentAge, String contactNo) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.contactNo = contactNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
}
