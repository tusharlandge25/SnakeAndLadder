package mypack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnyNumberOfPlayers {

	public static void main(String[] args) {
		
		System.out.print("Enter number of Players : ");
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
		sc.nextLine();
		System.out.println();
		while (endPosition < Game.END) {
			System.out.println("end position : " + endPosition);
			System.out.println();
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Player" + (i + 1) + "'s turn ");
				System.out.println("Press ENTER to Roll the dice");
				int randomNum = 0;
				if(sc.nextLine() != null) {
					randomNum = (int) (Math.random() * 6) + 1;
				}
				System.out.println("Player" + (i + 1) + " got " + randomNum);
				list.get(i).setCurPos(randomNum + list.get(i).getCurPos());
				System.out.println("Player" + (i + 1) + " position : " + list.get(i).getCurPos());
				System.out.println();
				if(list.get(i).getCurPos() >= Game.END) {
					System.out.println();
					System.out.println("Player" + (i + 1) + " Won.");
					winnerFound = true;
					break;
				}
				
				if (snakePositions.contains(list.get(i).getCurPos())) {
					System.out.println("Snake Bite");
					list.get(i).setCurPos(list.get(i).getCurPos() - mapForSnake.get(list.get(i).getCurPos()));
					System.out.println("Player" + (i + 1) + " position after snake : " + list.get(i).getCurPos());
				}
				
				if (ladderPositions.contains(list.get(i).getCurPos())) {
					System.out.println("Got the ladder");
					list.get(i).setCurPos(list.get(i).getCurPos() + mapForLadder.get(list.get(i).getCurPos()));
					System.out.println("Player" + (i + 1) + " position after ladder : " + list.get(i).getCurPos());
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
