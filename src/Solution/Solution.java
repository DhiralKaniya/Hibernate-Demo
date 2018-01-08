package Solution;

import java.util.Scanner;

import DAO.StudentDAO;
import Model.Student;

public class Solution {
	static Scanner scanner = new Scanner(System.in);
	static StudentDAO studentDAO ;
	public static void main(String[] args) {
		studentDAO = new StudentDAO();
		int n = 0;
		do {
			System.out.println("Press 1 for insert");
			System.out.println("Press 2 for update");
			System.out.println("Press 3 for delete");
			System.out.println("Press 4 for display");
			System.out.println("Press -1 for Exit!!");
			n = scanner.nextInt();
			switch(n) {
			case 1:
				addStudent();
				break;
			case 2:
				updateStudent();
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				displayStudent();
				break;
			case -1:
				System.out.println("Thank you!!");
				break;
			default:
				System.out.println("Please enter a valid value!!");
				break;
			}
		}while(n!=-1);
	}
	public static void addStudent() {
		scanner.nextLine();
		System.out.print("Enter Student name :- ");
		String name= scanner.nextLine();
		System.out.print("Enter Student age :- ");
		String age = scanner.nextLine();
		System.out.print("Enter Student contact no :- ");
		String contactno = scanner.nextLine();
		Student student = new Student(name,age,contactno);
		studentDAO.addStudent(student);
	}
	
	public static void updateStudent() {
		displayStudent();
		System.out.print("Enter Student id :- ");
		int id= scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Student name :- ");
		String name= scanner.nextLine();
		System.out.print("Enter Student age :- ");
		String age = scanner.nextLine();
		System.out.print("Enter Student contact no :- ");
		String contactno = scanner.nextLine();
		Student student = new Student(id,name,age,contactno);
		studentDAO.updateStudent(student);
	}
	
	public static void deleteStudent() {
		displayStudent();
		System.out.print("Enter Student id :- ");
		int id= scanner.nextInt();
		studentDAO.deleteStudent(id);
	}
	
	public static void displayStudent() {
		studentDAO.displayStudent();
	}
}
