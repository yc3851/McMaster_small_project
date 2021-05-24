
public class Sort {
	
	public static int[] sort(double[] games){
		int[] index = new int[games.length];
		for(int i = 0; i < games.length; i++) {
			index[i] = i;
		}
 		sort(games, 0, games.length - 1, index);
 		return index;
	}
	
	private static void sort(double[] a, int lo, int hi,int[] index)
	{
	if (hi <= lo) return;
	int j = partition(a, lo, hi, index); // Partition (see page 291).
	sort(a, lo, j-1, index); // Sort left part a[lo .. j-1].
	sort(a, j+1, hi, index); // Sort right part a[j+1 .. hi].
	}
	
	private static int partition(double[] a, int lo, int hi, int[] index){ 
		// Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo, j = hi+1; // left and right scan indices
		double v = a[index[lo]]; // partitioning item
		while (true){ // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[index[++i]], v)) if (i == hi) break;
			while (less(v, a[index[--j]])) if (j == lo) break;
			if (i >= j) break;
			exch(index, i, j);
		}
		exch(index, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}
	
	private static void exch(int[] ind, int i, int j) {
		int tmp = ind[i];
		ind[i] = ind[j];
		ind[j] =tmp;
	}
	
	private static boolean less (double x, double y) {  
		if(x <= y) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * function isSorted will return true if all the elements are sorted;
	 * @param x
	 * @return
	 */
    public static boolean isSorted(double[] games, int[] index) {
    	int n  =  games.length;
    	for(int i = 0; i < n-1; i++) {
    		if(less(games[index[i+1]], games[index[i]])){
    			return false;
    		}
    	}
    	return true;
    }
}
