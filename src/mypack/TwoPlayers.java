package mypack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwoPlayers {

	public static void main(String[] args) {
		
		System.out.println("Start");
		
		Map<Integer, Integer> mapForSnake = Game.getMapForSnakes();
		List<Integer> snakePositions = new ArrayList<>(mapForSnake.keySet());
		
		Map<Integer, Integer> mapForLadder = Game.getMapForLadders();
		List<Integer> ladderPositions = new ArrayList<>(mapForLadder.keySet());
		
		Player player1 = new Player(1);
		Player player2 = new Player(1);
		List<Player> list = new ArrayList<>();
		list.add(player1);
		list.add(player2);
		
		int endPosition = Game.START;
		boolean winnerFound = false;
		
		while (endPosition < Game.END) {
			System.out.println("end position : " + endPosition);
		    for (int i = 0; i < list.size(); i++) {
				int randomNum = (int) (Math.random() * 6) + 1;
				System.out.println("Player" + (i + 1) + " is playing and got " + randomNum);
				list.get(i).setCurPos(randomNum + list.get(i).getCurPos());
				System.out.println("Player" + (i + 1) + " position : " + list.get(i).getCurPos());
				
				if(list.get(i).getCurPos() >= Game.END) {
					System.out.println();
					System.out.println("Player" + (i + 1) + " Won.");
					winnerFound = true;
					break;
				}
				
				for(int snakePos : snakePositions) {
					if(list.get(i).getCurPos() == snakePos) {
						list.get(i).setCurPos(list.get(i).getCurPos() - mapForSnake.get(snakePos));
						System.out.println("Player" + (i + 1) + " position after snake : " + list.get(i).getCurPos());
						break;
					}
				}
				
				for(int ladderPos : ladderPositions) {
					if(list.get(i).getCurPos() == ladderPos) {
						list.get(i).setCurPos(list.get(i).getCurPos() + mapForLadder.get(ladderPos));
						System.out.println("Player" + (i + 1) + " position after ladder : " + list.get(i).getCurPos());
						break;
					}
				}
			}
		    if(winnerFound) break;
			System.out.println();
			if(player1.getCurPos() > player2.getCurPos()) {
				endPosition = player1.getCurPos();
			}else {
				endPosition = player2.getCurPos();
			}
		}
	}
}
