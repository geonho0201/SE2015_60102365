import java.util.Vector;


public class Lecture {
	
	private String name;
	private Student studentList;
//	private Vector<Student> students;
	
	public Lecture(){
		
	}
	
	public Lecture(String name){
		this.name = name;
	}
	
	public void addStudent(Student student){
		this.studentList = student;
//		this.students.add(student);
	}
	
//	public Vector<Student> getStudents() {return students;}
//	public void setStudents(Vector<Student> students) {this.students = students;}
	public Student getStudentList() {return studentList;}
	public void setStudentList(Student studentList) {this.studentList = studentList;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
}
