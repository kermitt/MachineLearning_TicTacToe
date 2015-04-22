package porting;

/* WIN weight = 2
 * CAT weight = 1 - giving cat some weight to  encourage defensive plays
 * LOSS weight = 0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Learner extends Kruft {
	// board positions
	// 0 | 1 | 2
	// ---|---|---
	// 3 | 4 | 5
	// ---|---|---
	// 6 | 7 | 8

	public Map<String, Cup> crossWins = new HashMap<String, Cup>();
	public List<String> XWinMinusTwo = new ArrayList<String>();

	private int crossWin = 0;
	private int naughtWin = 0;
	private int catWin = 0;

	public Learner() {
		_setup();
	}

	public void play(boolean crossLearns, boolean naughtLearns) {
		_clearBoard();

		List<StateAndChosenMove> states = new ArrayList<StateAndChosenMove>();

		boolean keepAlive = true;
		int count = 0;
		playing: while (keepAlive) {
			count++;
			if (count > 8) {
				keepAlive = false;
			}

			StateAndChosenMove sacm = new StateAndChosenMove();
			sacm.state = STATE; // this is the last state

			int side = count % 2 == 0 ? NAUGHT : CROSS; // cross plays first

			int choosenMove = _move(side); // now it is this state
			int finished = _isOver(side);

			sacm.move = choosenMove; // choosenMove = what happened now
			states.add(sacm);

			if (finished == 1 && side == CROSS) {
				crossWon(count, choosenMove, states);
				break playing;
			} else if (finished == 1 && side == NAUGHT) {
				naughtWon();
				break playing;
			} else if (finished == 0) {
				catWon(count, choosenMove, states);
				break playing;
			} else {
				// Not Finished Yet
			}
		}
	}

	public void report() {
		_log("WINS: X " + crossWin + "  O " + naughtWin + "    Cat's game "
				+ catWin);
	}

	public void showit(String msg, String state, String[] choices) {

		_clearBoard();

		String[] display = state.split("");

		int index = 0;
		for (int row = 0; row < BOARD.length; row++) {
			for (int col = 0; col < BOARD[row].length; col++) {
				String result = "" + display[index];
				if (result.equals("_")) {
					display[index] = " ";
				} else if (result.equals("O")) {
					display[index] = "O";
				} else if (result.equals("X")) {
					display[index] = "X";
				}
				index++;
			}
		}
		StringBuilder sb = new StringBuilder();

		String delimit = "---|---|---\n";
		String a = " " + display[0] + " | " + display[1] + " | " + display[2]
				+ "\t";
		String b = " " + display[3] + " | " + display[4] + " | " + display[5]
				+ "\t";
		String c = " " + display[6] + " | " + display[7] + " | " + display[8]
				+ "\t";

		a += "\t" + choices[0] + " | " + choices[1] + " | " + choices[2] + "\n";
		b += "\t" + choices[3] + " | " + choices[4] + " | " + choices[5] + "\n";
		c += "\t" + choices[6] + " | " + choices[7] + " | " + choices[8] + "\n";

		sb.append(msg + "\t" + state + "\n");
		sb.append(a);
		sb.append(delimit);
		sb.append(b);
		sb.append(delimit);
		sb.append(c);

		_log(sb.toString());
	}

	public void showLessonsLearntFromRandomStates(int some) {
		for (int i = 0; i < some; i++) {
			_clearBoard();

			String Xstate = XGENERATIONS
					.get((int) (Math.random() * XGENERATIONS.size()));
			String[] Xchoices = crossWins.get(Xstate).getWeightedChoices()
					.split(" ");
			showit(i + " of " + some + "  |  X to play", Xstate, Xchoices);
		}
	}

	public void crossWon(int count, int choosenMove,
			List<StateAndChosenMove> states) {
		
		int weight = 1;
		
		for (int i = 0; i < states.size(); i++) {
			StateAndChosenMove state = states.get(i);
			if (crossWins.containsKey(state.state)) {
				crossWins.get(state.state).addChoosenMove(state.move, weight);
			} else {
				Cup cup = new Cup();
				cup.addChoosenMove(state.move, weight);

				crossWins.put(state.state, cup);
			}

			if (i == states.size() - 3 && states.size() > 4) {
				XGENERATIONS.add("" + state.state);
			}
		}
		crossWin++;
	}

	public void naughtWon() {
		naughtWin++;
	}

	public void catWon(int count, int choosenMove,
			List<StateAndChosenMove> states) {
		int weight = 0;
		
		for (int i = 0; i < states.size(); i++) {
			StateAndChosenMove state = states.get(i);
			if (crossWins.containsKey(state.state)) {
				crossWins.get(state.state).addChoosenMove(state.move, weight);
			} else {
				Cup cup = new Cup();
				cup.addChoosenMove(state.move, weight);

				crossWins.put(state.state, cup);
			}

			if (i == states.size() - 3 && states.size() > 4) {
				XGENERATIONS.add("" + state.state);
			}
		}
		catWin++;
	}
}