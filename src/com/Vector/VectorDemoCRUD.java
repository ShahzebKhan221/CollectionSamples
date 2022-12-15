package com.Vector;

import java.util.*;

class Student{
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
	
	public Student() {
	}
	public Student(int studentid, String fname, String lname, String mobileno) {
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
interface StudentDAO{
	void insert(Vector<Student> students);
	void fetchAll(Vector<Student> students);
	void delete(Vector<Student> students);
	void update(Vector<Student> students);
	int [] findById(Vector<Student> students);
}
class StudentDAOImpl implements StudentDAO{

	@Override
	public void insert(Vector<Student> students) {
		// TODO Auto-generated method stub
Student student=new Student();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter student first name: ");
		student.setFname(sc.nextLine());
		System.out.print("Enter student last name: ");
		student.setLname(sc.nextLine());
		System.out.print("Enter student mobile no. : ");
		student.setMobileno(sc.nextLine());
		System.out.print("Enter student id: ");
		student.setStudentid(sc.nextInt());
		students.addElement(student);
		System.out.println(student.getStudentid()+" inserted into collection");
	}

	@Override
	public void fetchAll(Vector<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("Collection is empty");
			return;
		}
		Enumeration<Student> e = students.elements();
		while(e.hasMoreElements()==true) {
			Student element=e.nextElement();
			System.out.println(element);
		}
	}

	@Override
	public void delete(Vector<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter student id to delete record: ");
		int studentid=sc.nextInt();
		int index=-1;
		for(int i=0;i<students.size();i++) {
			Student student=students.get(i);
			if(student.getStudentid()==studentid) {
				index=i;
			}
			if(index==-1) {
				System.out.println("invalid student id given");
			}
			else {
				students.removeElementAt(index);
				System.out.println("student removed with id: "+studentid);
			}
		}
	}

	@Override
	public void update(Vector<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		int[]res=this.findById(students);
		if(res==null) {
			System.out.println("invalid id given");
			return;
		}
		Student student=new Student();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter modified student first name: ");
		student.setFname(sc.nextLine());
		System.out.print("Enter modified student last name: ");
		student.setLname(sc.nextLine());
		System.out.print("Enter modified student mobile no. : ");
		student.setMobileno(sc.nextLine());
		
		student.setStudentid(res[1]);
		
		students.set(res[0], student);
		System.out.println("record modified with student id: "+res[1]);
	}

	@Override
	public int[] findById(Vector<Student> students) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Existing student id to modify: ");
		int studentid=sc.nextInt();
		
		int index=-1;
		
		for(int i=0;i<students.size();i++) {
			Student student=students.get(i);
			if(student.getStudentid()==studentid) {
				index=i;
				break;
			}
		}
		if(index==-1) {
			int[] res=null;
			return res;
		}
		int []res=new int[2];
		res[0]=index;
		res[1]=studentid;
		return res;
	
	}
	
}

public class VectorDemoCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Student> students = new Vector<>();
		StudentDAO dao = new StudentDAOImpl();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. insert");
			System.out.println("2. fetch all");
			System.out.println("3. delete by employee id");
			System.out.println("4. modify existing employee record by id");
			System.out.println("5. exit program");
			
			System.out.print("enter your choice? 1/2/3/4/5: ");
			int choice=sc.nextInt();
			
			switch(choice) {
		
			case 1:
				dao.insert(students);
				break;
			case 2:
				dao.fetchAll(students);
				break;
			case 3:
				dao.delete(students);
				break;
			case 4:
				dao.update(students);
				break;
			case 5:
				System.out.println("Thank You for using my software");
				System.exit(0);
			}
		}
	}

}
