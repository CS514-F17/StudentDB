package studentdb;

/**
 * Driver class to execute the Student DB program.
 * @author srollins
 *
 */
public class Driver {

	/**
	 * main method expects one argument -- the directory
	 * where the files are stored.
	 * 
	 * Create a StudentList, print its contents, and print the
	 * top student.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//testing args array
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
		if(args.length != 1) {
			System.out.println("invalid usage");
			return;
		}
		
		String inputDirectory = args[0];
		System.out.println("Input directory: " + inputDirectory);
		//...use the variable inputDirectory
		
		
	}

}
