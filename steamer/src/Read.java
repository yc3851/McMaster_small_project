import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Read {
	
	//read game information
	public static ArrayList<Game> readGame() throws Exception {
		ArrayList<Game> games = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("data/games.csv"));
		br.readLine();
		String s;
		while ((s = br.readLine())!= null) {
			games.add(new Game(s));
		}
		br.close();
		return games;
	}
	
	//read player information
	public static ArrayList<Player> readPlayer() throws Exception {
		ArrayList<Player> players = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("data/player.txt"));
		String s;
		while ((s = br.readLine())!= null) {
			players.add(new Player(s));
		}
		br.close();
		return players;
	}
	
	//separate a line in a csv into string token
	public static ArrayList<String> getElements(String s) {
		
		ArrayList<String> elements = new ArrayList<>();
		String element = "";
		boolean inQuote = false; //boolean to check if the char is in the quote
		
		for (char c: s.toCharArray()) {
			if (c == ',') {
				if (inQuote == false) {
					elements.add(element);
					element = "";
				} else if (inQuote == true) {
					element += c;
				}
			} else if (c == '"') {
				if (inQuote == false) {
					inQuote = true;
				} else if (inQuote == true) {
					inQuote = false;
				}
			} else {
				element += c;
			}
		}
		elements.add(element);
		return elements;
	}

}
