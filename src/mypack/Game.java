package mypack;

import java.util.HashMap;

class Game {
	
	final public static int START = 1;
	
	final public static int END = 100;
	
	public static HashMap<Integer, Integer> getMapForSnakes(){
		/* HashMap :-
		 * key :- Position of the player
		 * Value :- Number to be subtracted from {key} position */
		HashMap<Integer, Integer> mapForSnakePositions = new HashMap<>();
		mapForSnakePositions.put(28, 18);
		mapForSnakePositions.put(44, 25);
		mapForSnakePositions.put(67, 40);
		mapForSnakePositions.put(79, 30);
		mapForSnakePositions.put(97, 57);
		return mapForSnakePositions;
	}
	
	public static HashMap<Integer, Integer> getMapForLadders(){
		/* HashMap :-
		 * key :- Position of the player
		 * Value :- Number to be added in {key} position */
		HashMap<Integer, Integer> mapForLadderPositions = new HashMap<>();
		mapForLadderPositions.put(7, 20);
		mapForLadderPositions.put(21, 60);
		mapForLadderPositions.put(39, 57);
		mapForLadderPositions.put(56, 30);
		mapForLadderPositions.put(71, 20);
		return mapForLadderPositions;
	}
}
