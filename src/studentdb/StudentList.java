package studentdb;
import java.util.ArrayList;

public class StudentList {

	//the StudentList is a list of Student objects.
	private ArrayList<Student> students;
	
	//construct a StudentList
	public StudentList() {
		this.students = new ArrayList<Student>();
	}
	
	public StudentList(int size) {
		this.students = new ArrayList<Student>(size);
	}

	/**
	 * Add a new student to the list.
	 * @param student
	 */
	public void addStudent(Student student) {
		students.add(student);
	}
	
	/**
	 * Return a string representation of this list.
	 */
	public String toString() {
		String result = "";
		
		for(Student student: students) {
			result += student.toString() + "\t";
		}
				
		return result;
	}
	
	/**
	 * Return the name of the top student --
	 * that is the student with the highest
	 * average score.
	 * @return
	 */
	public String topStudent() {
		
		if(students.size() == 0) {
			return null;
		}
		
		double topScore = students.get(0).getAverage();
		String topName = students.get(0).getName();
		
		for(Student s: students) {
			double avg = s.getAverage();
			if(avg > topScore) {
				topScore = avg;
				topName = s.getName();
			}
		}
		return topName;
	}	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> scores1 = new ArrayList<Integer>();
		scores1.add(90);
		scores1.add(90);
		scores1.add(90);
		Student s1 = new Student("Sally", scores1);
		
		ArrayList<Integer> scores2 = new ArrayList<Integer>();
		scores2.add(70);
		scores2.add(80);
		scores2.add(90);
		Student s2 = new Student("Bob", scores2);
		
		StudentList sl = new StudentList();
		sl.addStudent(s1);
		sl.addStudent(s2);

		System.out.println(sl.toString());
		//System.out.println(sl);
		
		
	}
}
