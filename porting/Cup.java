package porting;

public class Cup {
	
	private int[] moves = new int[] { 0,0,0,0,0,0,0,0,0};
	
	public void addChoosenMove(int move, int weight) {
		moves[move] += weight; // 2 for winning, 1 for scratch
	}
	
	public String getWeightedChoices() {

		StringBuilder out = new StringBuilder();
		for ( int state : moves ) {
			out.append(state + " ");
		}
		
		return out.toString();
	}
}