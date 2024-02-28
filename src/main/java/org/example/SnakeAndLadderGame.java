package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SnakeAndLadderGame {

    private ArrayDeque<Player> playersturn;
    private GameBoard board;
    private Dice dice;

    public  SnakeAndLadderGame(int size, int countDice) {
        board= new GameBoard(size);
        dice = new Dice(countDice);
        playersturn = new ArrayDeque<>();
//        playersturn.addLast(new Player("Mukesh",1));
//        playersturn.addLast(new Player("Sharika",1));
    }


    public void startGame() {
        boolean noWinner = true;
        while(noWinner){
            Player nextTurn = playersturn.remove();
            int move = dice.roll();
            int nextPosition = nextTurn.getPosition() + move;

            if(nextPosition!=board.getSize() && nextPosition>(board.getSize()- dice.getCount())){
                System.out.println(nextTurn.getName()+" [got "+ move+"] can't move.");
                playersturn.add(nextTurn);
                continue;
            }

            boolean winner = getBoard().move(nextTurn, nextPosition,move);
            if(winner){
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println(nextTurn.getName()+" is the Winner...........Yayyyy.!!!!!!");
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                return;

            }
            playersturn.add(nextTurn);

        }

    }
}
