import java.util.ArrayList;

public class Graph {
	private int V;
	private ArrayList<Edge>[] adj;
	
	@SuppressWarnings("unchecked")
	public Graph(int size) {
		this.V = size+1;
		this.adj = (ArrayList<Edge>[]) new ArrayList[size+1];
		for (int i=0; i<this.V; ++i) {
			this.adj[i] = new ArrayList<Edge>();
		}
	}
	
	public int getV() {
		return this.V;
	}
	
	public ArrayList<Edge> getAdjList(int i) {
		return this.adj[i];
	}
	
	//undirected graph
	public void addEdge(Edge e) {
		validateVertex(e.getGame());
        validateVertex(e.getPlayer());
		adj[e.getGame()].add(e);
		adj[e.getPlayer()].add(e);
	}
	
	private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
