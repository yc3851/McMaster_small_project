import java.util.ArrayList;

public class Game implements Comparable<Game>{
	
	private final String name;
	private final int positive;
	private final int negative;	
	private final double price;

	/**
	 * Constructor for Game
	 * @param s line from csv file
	 */
	public Game(String s) {
		ArrayList<String> elements = Read.getElements(s);
		
		/*for(int i = 0; i < elements.size(); i++ ) {
			System.out.println(elements.get(i));
		}*/
		this.name = elements.get(2);
		this.positive = Integer.parseInt(elements.get(6));
		this.negative = Integer.parseInt(elements.get(7));
		this.price = Double.parseDouble(elements.get(14))/100;
	}
	
	public Game(String s, double price) {
		this.name = s;
		this.price = price;
		this.negative = 0;
		this.positive = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public double positiveRate() {
		return ((double)this.positive/(this.positive + this.negative))*100;
	}

	@Override
	public int compareTo(Game o) {
		if (this.name.compareTo(o.getName())< 0){
			return -1;
        }
        else if(this.name.compareTo(o.getName())> 0){
        	return 1;
        }
		return 0;
	}
}
	
