package studentdb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentListBuilder {

	/**
	 * Construct a StudentList from the student files in the
	 * directory specified.
	 * 
	 * The file is expected to be a name followed by three
	 * int scores.
	 * 
	 * The name of the file will be a seven-digit 
	 * id number followed by .txt.
	 * 
	 * All other files should be ignored.
	 * 
	 * Skip files that contain invalid data.
	 * 
	 * @param directory
	 * @return
	 */
	public StudentList buildStudentList(String directory) {
		
		StudentList sl = new StudentList();		
		File file = new File(directory);
		if(!file.isDirectory()) {
			return null;
		}
		File[] files = file.listFiles();
		
		for(File f: files) {
			String name = f.getName();
			if(!isValid(name)) {
				continue;
			}
			Student s = processFile(f);
			if(s != null) {
				sl.addStudent(s);
			}			
		}		
		
		//processFile -- if null is returned, don't add it to the list!		
		return sl;
		
	}
	
	private boolean isValid(String name) {
		if(!name.endsWith(".txt")) {
			return false;
		}
		String[] result = name.split("\\.");
		if(result.length != 2) {
			return false;
		}
		String noExtension = result[0];
		if(noExtension.length() != 7) {
			return false;
		}
		for(int i = 0; i < noExtension.length(); i++) {
			if(!Character.isDigit(noExtension.charAt(i))) {
				return false;
			}
		}		
		return true;
	}
	
	/**
	 * Processes a single file. Returns a student object to represent
	 * the file. Returns null in case the file was not valid.
	 * @param file
	 * @return
	 */
	private Student processFile(File file) {
		//create student reference
		Student s = null;
		
		//read in from the file
		//instantiate the object
		try(Scanner input = new Scanner(file)) {
			 
			String name = null;
			ArrayList<Integer> scores = new ArrayList<Integer>();
			
			//TODO: figure out a less hacky way to do this.
			if(input.hasNext()) {
				name = input.nextLine();
			}
			if(input.hasNextInt()) {
				scores.add(input.nextInt());
			}
			if(input.hasNextInt()) {
				scores.add(input.nextInt());
			}
			if(input.hasNextInt()) {
				scores.add(input.nextInt());
			}
			if(scores.size() != 3 || input.hasNextInt()) {
				return null;
			}
			s = new Student(name, scores);
			
		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return null;
		}		
		
		//return
		return s;
	}
	
	
	//consider some private helper methods!
}
