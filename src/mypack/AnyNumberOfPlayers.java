package mypack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnyNumberOfPlayers {

	public static void main(String[] args) {
		
		System.out.println("Start");
		System.out.print("Enter number of Players comes to play : ");
		Scanner sc = new Scanner(System.in);
		int numberOfPlayers = sc.nextInt();
		
		Map<Integer, Integer> mapForSnake = Game.getMapForSnakes();
		List<Integer> snakePositions = new ArrayList<>(mapForSnake.keySet());
		
		Map<Integer, Integer> mapForLadder = Game.getMapForLadders();
		List<Integer> ladderPositions = new ArrayList<>(mapForLadder.keySet());
		
		List<Player> list = new ArrayList<>();
		for(int i = 0; i < numberOfPlayers; i++) {
			list.add(new Player(1));
		}
		
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
				
				if (snakePositions.contains(list.get(i).getCurPos())) {
					list.get(i).setCurPos(list.get(i).getCurPos() - mapForSnake.get(list.get(i).getCurPos()));
					System.out.println("Player" + (i + 1) + " position after snake : " + list.get(i).getCurPos());
					break;
				}
				
				if (ladderPositions.contains(list.get(i).getCurPos())) {
					list.get(i).setCurPos(list.get(i).getCurPos() + mapForLadder.get(list.get(i).getCurPos()));
					System.out.println("Player" + (i + 1) + " position after snake : " + list.get(i).getCurPos());
					break;
				}
			}
			if(winnerFound) break;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getCurPos() > endPosition) {
					endPosition = list.get(i).getCurPos();
				}
			}
			System.out.println();
		}
	}
}
