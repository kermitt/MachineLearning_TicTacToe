package porting;

import java.util.ArrayList;
import java.util.List;

public class Kruft {
	// board positions
	//  0 | 1 | 2
	// ---|---|---
 	//	3 | 4 | 5
	// ---|---|---
 	//	6 | 7 | 8
	
	public int[][] WON = new int[8][3];
	public int[][] BOARD = new int[3][3]; 
	public int EMPTY = -1;
	public int CROSS = 1;
	public int NAUGHT = 0;
	public int GAME_STEP = 0;
	public String STATE = "________";
	public List<String> XGENERATIONS = new ArrayList < String >();

	public void _clearBoard() {
		STATE = "________";
		GAME_STEP=0;
		for ( int row = 0; row < BOARD.length; row++) {
			for ( int col = 0; col < BOARD[row].length; col++) {
				BOARD[row][col]=-1;
			}
		}
	}

	public int[] _index2indices( int index ) {
		int row = -1;
		int col = -1;
		if ( index == 0 ) {
			row = 0;
			col = 0;
		} else if ( index == 1 ) {
			row = 0;
			col = 1;			
		} else if ( index == 2 ) {
			row = 0;
			col = 2;			
		} else if ( index == 3 ) {
			row = 1;
			col = 0;			
		} else if ( index == 4 ) {
			row = 1;
			col = 1;			
		} else if ( index == 5 ) {
			row = 1;
			col = 2;			
		} else if ( index == 6 ) {
			row = 2;
			col = 0;			
		} else if ( index == 7 ) {
			row = 2;
			col = 1;			
		} else if ( index == 8 ) {
			row = 2;
			col = 2;			
		}
		
		return new int[] { row, col };
	}
	
	public void _setState(){
		STATE = "";
		for ( int row = 0; row < BOARD.length; row++) { 
			for ( int col = 0 ; col < BOARD[row].length; col++) { 
				if ( BOARD[row][col] == CROSS) {
					STATE += "X";
				} else if ( BOARD[row][col] == NAUGHT ) { 
					STATE += "O";
				} else { 
					STATE += "_";
				}
			}
		}
	}

	public int _move(int side) {

		int choice = -1;
		ArrayList < Integer > possible = new ArrayList < Integer > (); 
		int index = 0;
		for ( int row = 0 ; row < BOARD.length; row++) { 
			for ( int col = 0; col < BOARD[row].length; col++ ) {
				if ( BOARD[row][col] == EMPTY ) { 
					possible.add( new Integer( index ));
				}
				index++;
			}
		}
		choice = possible.get( (int)(Math.random() * possible.size()));

		int[] rc = _index2indices( choice );
		BOARD[rc[0]][rc[1]]=side;

		_setState(  ) ; 
		
		return choice;
	}

	protected int _isOver(int side) { 
		// 1 = won
		// 0 = cat's game
		//-1 = not over yet
		
		int result = -1;

		for ( int i = 0 ; i < WON.length; i++) { 
				
				int[] one = _index2indices( WON[i][0]);
				int[] two = _index2indices( WON[i][1]);
				int[] three = _index2indices( WON[i][2]);
				
				if ( BOARD[one[0]][one[1]] == side && 
						BOARD[two[0]][two[1]] == side && 
						BOARD[three[0]][three[1]] == side ) {
					result = 1;
				}
		}

		if ( GAME_STEP == 8 && result != 1 ) {
			result = 0;
		}
		GAME_STEP++;
		return result;
	}
	
	public void _log(String s ) {
		System.out.println( s ); 
	}
	
	protected void  _setup() {
		
		_clearBoard();
		
		// any of the following = win
		WON[0] = new int[] {0,1,2};
		WON[1] = new int[] {3,4,5};
		WON[2] = new int[] {6,7,8};
		WON[3] = new int[] {0,3,6};
		WON[4] = new int[] {1,4,7};
		WON[5] = new int[] {2,5,8};
		WON[6] = new int[] {0,4,8};
		WON[7] = new int[] {2,4,6};		
	}	
}