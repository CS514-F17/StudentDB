package studentdb;

import java.util.ArrayList;

public class Student {

	//a student has a name and a list of exam scores
	//exam scores are integers
	private String name;
	private ArrayList<Integer> scores;
	
	
	//constructor
	public Student(String name, ArrayList<Integer> scores) {
		this.name = name;
		this.scores = scores;
		//calc average
	}
	
	/**
	 * Return this student's average exam score.
	 * @return
	 */
	public double getAverage() {
		double sum = 0;
		for(int score: scores) {
			sum += score;
		}
		return sum / scores.size();
		//return average;
	}
	
	/**
	 * Return this student's name.
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return name + " " + this.getAverage();
	}
	
	public static void main(String[] arg) {
		
		ArrayList<Integer> scores1 = new ArrayList<Integer>();
		scores1.add(90);
		scores1.add(100);
		scores1.add(80);
		Student s1 = new Student("Sally", scores1);
		System.out.println("Name: " + s1.getName()); //expected Sally
		System.out.println("Average: " + s1.getAverage()); //expected 90
		
	}
}
