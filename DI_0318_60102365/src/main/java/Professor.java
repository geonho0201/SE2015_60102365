
public class Professor {
	
	private String Name;
	private Lecture lecture;
	
	public Professor(){
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public Professor(String Name){
		this.Name = Name;
	}
	public void addLecture(Lecture lecture) {
		// TODO Auto-generated method stub
		this.lecture = lecture;
	}
	public void showLecture() {
		// TODO Auto-generated method stub
		System.out.println("강좌명 : " + lecture.getName());
		System.out.println("수강학생 : " + lecture.getStudentList().getName());
//		System.out.println(lecture.getStudents().toString());
	}
}
