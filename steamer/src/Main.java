import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Game> games = Read.readGame();
		ArrayList<Player> players = Read.readPlayer();
		Player user = new Player("0");
		
		/*
		double[] test = {17, 13, 14, 15, 16};
		
		for (int i=0; i<test.length; i++) {
			System.out.println(test[i]);
		}
		
		int[] result = Sort.sort(test);
		
		for (int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}*/
		
		/*
		 * add games that are not in the database
		FileWriter pw = new FileWriter("data/apiout.csv",true); 
		BufferedReader error = new BufferedReader(new FileReader("data/error.txt"));
		String s;
		while ((s = error.readLine())!= null) {
			boolean test = false;
			for(int i = 0; i < games.size(); i++) {
				if(s.equals(games.get(i).name)) test = true;
			}
			if(test == false) {
				pw.append("unknow,unknow," + s +",unknow,unknow,,-1,-1,-1,unknow,-1,-1,-1,-1,-1,-1,-1");
				pw.append("\n");
				Game temp = new Game(s, -1);
				games.add(temp);
			}
			
		}
		error.close();
		pw.close();*/
		
		
		
		Scanner reader1 = new Scanner(System.in);  // Reading from System.in
		int flag = 1;
		String game1;
		String game2;
		String game3;
        System.out.println("Please enter your most liked game: ");
		do {
	        game1 = reader1.nextLine();
	        if (Search.binarySearch(games, 0, games.size()-1, game1) >= 0) {
	        	user.addPurchase(1, game1);
	            flag = 2;
	        }
	        else {
	        	System.out.println("Game is not in our database, please try again: ");
	        }
	    } while (flag == 1);
		
		flag = 1;
		System.out.println("Please enter your second liked game: ");
		do {
			game2 = reader1.nextLine();
	        if (Search.binarySearch(games, 0, games.size()-1, game2) >= 0) {
	        	user.addPurchase(2, game2);
	            flag = 2;
	        }
	        else {
	        	System.out.println("Game is not in our database, please try again: ");
	        }
	    } while (flag == 1);
		
		flag = 1;
		System.out.println("Please enter your third liked game: ");
		do {
			game3 = reader1.nextLine();
	        if (Search.binarySearch(games, 0, games.size()-1, game3) >= 0) {
	        	user.addPurchase(3, game3);
	            flag = 2;
	        }
	        else {
	        	System.out.println("Game is not in our database, please try again: ");
	        }
	    } while (flag == 1);
		
		reader1.close();
		
		/*
		for (int i=0; i<games.size(); i++) {
			if(Search.binarySearch(games, 0, games.size()-1, games.get(i).getName()) == -1){
			System.out.println(games.get(i).getName() + " is not found");
			}
		}*/
		
		//System.out.println("Path of Exile".compareTo("PC Gamer"));
		//System.out.println("finish array");
		//System.out.println(games.size());
		//System.out.println(players.size());
		
	    /*
		for (int i=0; i<games.size(); i++) {
			System.out.println(games.get(i).getName());
		}*/
		
		
		HashMap<String, Integer> gameMap = new HashMap<>();
		for (int i=0; i<games.size(); i++) {
			String temp = games.get(i).getName().replaceAll("[^A-Za-z0-9]", "");
			temp = temp.toUpperCase();
			gameMap.put(temp, i);
		}
		
		
		HashMap<String, Integer> playerMap = new HashMap<>();
		for (int i=0; i<players.size(); i++) {
			playerMap.put(players.get(i).getId(), games.size()+i);
		}
		
		
		Graph gameGraph = Buildgraph.GameGraph(gameMap, playerMap, games,players );
		//System.out.println("finish graph");
		
		Buildgraph.addPlayer(gameGraph, user, gameMap);
		
		ArrayList<Game> output = recommend(gameGraph,games, user);
		printGame(output);
		
		/*
		double[] result = GraphAlgo.collaborative(gameGraph, games);
		
		int[] sorted = Sort.sort(result);
		
		System.out.println(games.get(sorted[sorted.length - 1]).getName());
		System.out.println(games.get(sorted[sorted.length - 2]).getName());
		System.out.println(games.get(sorted[sorted.length - 3]).getName());
		System.out.println(games.get(sorted[sorted.length - 4]).getName());
		System.out.println(games.get(sorted[sorted.length - 5]).getName());*/
		
	}
	
	public static void printGame(ArrayList<Game> games) {
		for(int i = 0; i < games.size(); i++) {
			System.out.println(i+1 + " recommendation is " +games.get(i).getName());
			System.out.println("Price: " +games.get(i).getPrice() + " Positive Rate: " + games.get(i).positiveRate());
		}
	}
	
	public static ArrayList<Game> recommend(Graph newGraph, ArrayList<Game> games, Player user){
		ArrayList<Game> temp = new ArrayList<Game>();
		double[] result = GraphAlgo.collaborative(newGraph, games);
		int[] sorted = Sort.sort(result);
		int i = 1;
		int added = 0;
		while(added < 5) {
			if(gameExit(user, sorted[sorted.length - i], games) == false) {
				temp.add(games.get(sorted[sorted.length - i]));
				added++;
			}
			i++;
		}
		return temp;
	}
	
	private static boolean gameExit(Player user, int i, ArrayList<Game> games) {
		Game test = games.get(i);
		String name = test.getName();
		ArrayList<String> purchased = user.getPurchased();
		for(int j = 0; j < purchased.size();j++) {
			if(name.compareTo(purchased.get(j)) == 0)return true;
		}
		
		return false;
	}
}
