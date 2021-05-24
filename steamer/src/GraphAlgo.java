import java.util.ArrayList;

public class GraphAlgo {
	
	public static double[] collaborative(Graph g, ArrayList<Game> games) {
		double[] gamePlay = new double[games.size()];
		
		for(int i = 0; i<gamePlay.length; i++) {
			gamePlay[i]=0;
		}
		
		for (Edge e1: g.getAdjList(g.getV() - 1)) {
			double firstLayerW = e1.getRelative();
			int firstLayerT = e1.getGame();
			//System.out.println("firstLayerT has " + firstLayerT);
			
			for (Edge e2: g.getAdjList(firstLayerT)) {
				double secondLayerW = e2.getRelative();
				int secondLayerT = e2.getPlayer();
				//System.out.println("secondLayerT has " + secondLayerT);
				
				for (Edge e3: g.getAdjList(secondLayerT)) {
					double thridLayerW = e3.getRelative();
					int thridLayerT = e3.getGame();
					//System.out.println("thridLayerT has " + thridLayerT);
					gamePlay[thridLayerT] = gamePlay[thridLayerT] + firstLayerW*secondLayerW*thridLayerW;
				}
			}
		}
		return gamePlay;
	}

}
