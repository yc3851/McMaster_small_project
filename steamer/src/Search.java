import java.util.ArrayList;

public class Search {
	
	// Returns index of x if it is present in ArrayList<Game> else return -1 
    public static int binarySearch(ArrayList<Game> games, int l, int r, String s) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            
            String database = games.get(mid).getName();
            String test = s;
            database = database.toUpperCase();
            test = test.toUpperCase();
            
            // If the element is present at the 
            // middle itself 
            if (games.get(mid).getName().compareTo(s) == 0 || database.compareTo(test) == 0) {
            	//System.out.println("database.compareTo(test) is" + database.compareTo(test));
            	//System.out.println("mid is " + games.get(mid).getName() + "games.get(mid).getName().compareTo(s) is " + games.get(mid).getName().compareTo(s));
            	return mid;
            }
                 
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (database.compareTo(test) > 0) {
            	//System.out.println("database.compareTo(test) is" + database.compareTo(test));
            	//System.out.println("mid is " + games.get(mid).getName() + "games.get(mid).getName().compareTo(s) is " + games.get(mid).getName().compareTo(s));
                return binarySearch(games, l, mid - 1, s); 
            }
  
            // Else the element can only be present 
            // in right subarray 
            //System.out.println("database.compareTo(test) is" + database.compareTo(test));
            //System.out.println("mid is " + games.get(mid).getName() + "games.get(mid).getName().compareTo(s) is " + games.get(mid).getName().compareTo(s));
            return binarySearch(games, mid + 1, r, s); 
        } 
  
        // We reach here when element is not present 
        // in array 
        
        return -1; 
    }
   

}
