import java.util.ArrayList;
import java.util.PrimitiveIterator.OfDouble;

public class Player {

	private final String id;
	private ArrayList<String> purchased;

	public Player() {
		this.id = "Current user";
		purchased = new ArrayList<String>();
	}

	/**
	 * Constructor for Player
	 * 
	 * @param s line from csv file
	 */
	public Player(String id) {
		this.id = id;
		purchased = new ArrayList<String>();
	}

	/**
	 * get the id from player
	 * 
	 * @return long for player id
	 */
	public String getId() {
		return this.id;
	}

	public void addPurchase(int index, String purchased) {
		this.purchased.add(index - 1, purchased);
	}

	public ArrayList<String> getPurchased() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < purchased.size(); i++) {
			temp.add(purchased.get(i));
		}
		return temp;
	}

	public void printPurchase() {
		for (int i = 0; i < purchased.size(); i++) {
			System.out.print(purchased.get(i) + " ");
			System.out.println();
		}
	}

	public boolean isDuplicate(String game) {
		for (int i = 0; i < purchased.size(); i++) {
			if (purchased.get(i).equals(game)) {
				return true;
			}
		}
		return false;
	}

	public boolean isNull() {
		return this.purchased.isEmpty();

	}
}
