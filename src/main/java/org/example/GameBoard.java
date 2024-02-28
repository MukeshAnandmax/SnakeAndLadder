package org.example;

import lombok.*;

import java.util.HashMap;

@Getter
@Setter
public class GameBoard {

    private int size;
    private HashMap<Integer, Integer> snake;
    private HashMap<Integer, Integer> ladder;

    public GameBoard(int size) {
        this.size = size;
        snake = new HashMap<>();
        ladder = new HashMap<>();
    }

    public void addSnake(int start, int end) {
        this.snake.put(start, end);
    }

    public void addLadder(int start, int end) {
        this.ladder.put(start, end);
    }

    public boolean move(Player player, int nextPosition, int move) {

        if (nextPosition == size) {
            System.out.println("=======================================================================");
            System.out.println(player.getName() + " [got " + move + "] (moved from " + player.getPosition() + " to " + nextPosition + ")");
            System.out.println("=======================================================================");
            return true;
        } else if (snake.containsKey(nextPosition)) {

            int reducedMove = snake.get(nextPosition);
            System.out.println("-----------------------------------------------------------------------");

            System.out.println(player.getName() + " [got " + move + "] is bitten by Snake...LOL!!(moved from " + nextPosition + " to " +
                    reducedMove + ")");
            System.out.println("-----------------------------------------------------------------------");

            player.setPosition(reducedMove);
        } else if (ladder.containsKey(nextPosition)) {
            int increasedMode = ladder.get(nextPosition);
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(player.getName() + " [got " + move + "] got a Ladder...Yayyy!!(moved from " + nextPosition + " to " +
                    increasedMode + ")");
            System.out.println("-----------------------------------------------------------------------");

            player.setPosition(increasedMode);
        } else {
            System.out.println(player.getName() + " [got " + move + "] (moved from " + player.getPosition() + " to " + nextPosition + ")");
            player.setPosition(nextPosition);
        }

        return false;
    }


}
