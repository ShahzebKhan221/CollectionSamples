package com.Stack;
import java.util.*;

class Student1{
	private int studentid;
	private String fname;
	private String lname;
	private String mobileno;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	Student1(){
		
	}
	public Student1(int studentid, String fname, String lname, String mobileno) {
	
		this.studentid = studentid;
		this.fname = fname;
		this.lname = lname;
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		String str=studentid+"\t"+fname+"\t"+lname+"\t"+mobileno;
		return str;
	}
}
class MyStack{
	private Stack<Student1> student=new Stack<>();
	
	public void push(Student1 students) {
		student.push(students);
		System.out.println(students+" inserted into stack collection");
	}
	public void pop() {
		if(student.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		Student1 remove=student.pop();
		System.out.println(remove+" removed from stack");
	}
	public void show() {
		if(student.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		for(Iterator<Student1> itr=student.iterator();itr.hasNext()==true;) {
			Student1 student=itr.next();
			System.out.println(student);
		}
	}
}
public class StackDemoCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
MyStack myStack=new MyStack();
		
		while(true) {
			System.out.println("1. register new student in stack");
			System.out.println("2. remove last student record in stack");
			System.out.println("3. display student stack");
			System.out.println("4. exit programme");
			
			Scanner sc=new Scanner(System.in);
			System.out.print("enter your choice? 1/2/3/4: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				Student1 student=new Student1();
				Scanner sc1=new Scanner(System.in);
				System.out.print("Enter student first name: ");
				student.setFname(sc1.nextLine());
				System.out.print("Enter student last name: ");
				student.setLname(sc1.nextLine());
				System.out.print("Enter student mobile no. : ");
				student.setMobileno(sc1.nextLine());
				System.out.print("Enter student id: ");
				student.setStudentid(sc1.nextInt());
				myStack.push(student);
				break;
			case 2:
				myStack.pop();
				break;
			case 3:
				myStack.show();
				break;
			case 4:
				System.out.println("Thank you for using my software");
				System.exit(0);
			default:
				System.out.println("invalid operation given");
				break;
			}
		}
	}

}
