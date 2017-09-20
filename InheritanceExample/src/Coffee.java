
public class Coffee extends Beverage {

	private boolean isDecaf;
	
	public Coffee(int ounces, boolean isDecaf) {
		super(ounces);		
		this.isDecaf = isDecaf;
	}
	
	public String toString() {
		return "Coffee - size: " + ounces + " decaf? " + isDecaf;
	}
	
	public void drink() {
		System.out.println("Wow, hot coffee!");
		super.drink();
	}
	
	public boolean isDecaf() {
		return isDecaf;
	}
	
	public String getServingGlass() {
		return "Cup";
	}
}
