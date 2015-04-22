package porting;

import porting.Cup;
import porting.Learner;

public class LearnerTest {

	private static Learner learner = new Learner();

	public static void main(String... args) {
		learner._log("Begin testing the extended utility object named 'Kruft'");
		clearboard_test();
		index2indices_test();
		setState_test();
		move_test();
		isOver_test(); 
		setup_test();
		learner._log("Test the Cup object which is the object in the HashMaps that store different states; this Cups contain the scores of possible moves");
		cup_test();
		learner._log("Test the Learner.java object!");
		learner._log("The end");
	}
	/// ------------------------ BEGIN Cup.java test
	private static void cup_test() {
		Cup cup = new Cup();
		
		int winning_move = 2;
		int draw_move = 1;
		// place a winning move in the middle 
		cup.addChoosenMove(4, winning_move);
		// place a drawgame in the middle of thee bottom
		cup.addChoosenMove(7, draw_move);
		
		String expectedLesson  = "0 0 0 0 2 0 0 1 0 ";
		String lessonsLearnt = cup.getWeightedChoices();

		if ( expectedLesson.equals(lessonsLearnt)) {
			learner._log("true cup_test");
		} else {
			learner._log("false cup_test");
		}
	}
	
	/// ------------------------ BEGIN Kruft.java tests
	private static void setup_test() { 
		Learner L = new Learner(); 

		// is  the state set to  the default? 
		// is the WON matrix properly setup?
		if  ( L.STATE.equals("________") && ( L.WON[0][0] == 0 && L.WON[0][1] == 1)) {
			learner._log("true setup_test");
		} else {
			learner._log("false setup_test");
		}
	}
	
	
	private static void isOver_test() { 
		learner._clearBoard();
		learner.BOARD[0][0]=learner.CROSS;
		learner.BOARD[0][1]=learner.NAUGHT;
		learner.BOARD[0][2]=learner.CROSS;
		learner._setState();
		
		int won = 1;
		int cat_game = 0;
		int not_finished_yet = -1;
		
		if ( learner._isOver(learner.CROSS) != not_finished_yet) {
			learner._log("false isOver_test 1 of 3 : not unfinished");
		} else {
			
			learner.GAME_STEP = 8; // X nor O && game step 8? cat game
			
			if ( learner._isOver( learner.CROSS) != cat_game ) {
				learner._log("false isOver_test 2 of 3 : not cat's game");
			} else { 
				learner._clearBoard();
				learner.BOARD[0][0]=learner.CROSS;
				learner.BOARD[0][1]=learner.CROSS;
				learner.BOARD[0][2]=learner.CROSS;
				int result = learner._isOver(learner.CROSS);

				if ( result == won ) { 
					learner._log("true isOver_test");
				} else {
					learner._log("false isOver_test 3 of 3 : not 'won'");
				}
			}
		}	
	}
	
	private static void move_test() {
		// _move accepts a CROSS or NAUGHT and moves
		// into a randomly picked legal location
		//
		// test = call clearBoard and then move
		// and see if the state has changed
		
		learner._clearBoard();
		learner._move(learner.CROSS);

		boolean isOk = false;
		if ( learner.STATE.contains("X")) {
			isOk = true;
		}
		
		learner._log(isOk + " move_test");
	}
	
	private static void setState_test() {
		learner._clearBoard(); // clean the board
		learner.BOARD[0][0]=learner.CROSS; // dirty it
		learner._setState();
		
		boolean isOk = false;
		if ( learner.STATE.equals("X________")) {
			isOk = true;
		}
		learner._log( isOk + " setState_test" );
	}
	
	private static void index2indices_test() { 
		// 0 ~ 8 into [][]
		// board positions
		//  0 | 1 | 2
		// ---|---|---
	 	//	3 | 4 | 5
		// ---|---|---
	 	//	6 | 7 | 8
		
		boolean isOk = true; 
		
		int bottomRightCell = 8;
		int[] row_col = learner._index2indices(bottomRightCell);
		if ( row_col[0] != 2 || row_col[1] != 2 ) {
			isOk = false;
		}
		
		int middleMiddleCell = 4;
		row_col = learner._index2indices(middleMiddleCell);
		if ( row_col[0] != 1 || row_col[1] != 1 ) {
			isOk = false;
		}
		
		int topLeftCell = 0;
		row_col = learner._index2indices(topLeftCell);
		if ( row_col[0] != 0 && row_col[1] != 0 ) {		
			isOk = false;
		}
		
		learner._log(isOk + " index2indices_test" ); 
	}
	
	private static void clearboard_test() {
		// dirty the board 
		learner.BOARD[0][0]=learner.CROSS;
		learner.BOARD[0][1]=learner.NAUGHT;
		learner.BOARD[0][2]=learner.CROSS;
		
		// clear the board
		learner._clearBoard();
		
		boolean isOk = true;
		for ( int row = 0; row < learner.BOARD.length; row++) {
			for ( int col = 0; col < learner.BOARD[row].length; col++) { 
				if  ( learner.BOARD[row][col] != learner.EMPTY) {
					isOk = false;
				}
			}
		}
		learner._log(isOk + " clearboard_test" ); 
	} 
}
