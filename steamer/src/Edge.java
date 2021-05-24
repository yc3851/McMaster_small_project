
public class Edge {
	private final int game;
	private final int player;
	private final double relativePlay;
	
	public Edge(int game, int player, double weight) {
		this.game = game;
		this.player = player;
		this.relativePlay = weight;
	}
	
	public int getGame() {
		return this.game;
	}
	
	public int getPlayer() {
		return this.player;
	}
	
	public double getRelative() {
		return this.relativePlay;
	}
}