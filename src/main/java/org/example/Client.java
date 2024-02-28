package org.example;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        boolean flag = true;
        int choice = 0;
        while (flag) {

            System.out.println("Select the option");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("you want to play with default configuration?: [1]");
            System.out.println("you want to add your snake , ladder , number of dice and board size?: [2]");
            System.out.println("----------------------------------------------------------------------------");
            System.out.print("choice: ");

            choice = scan.nextInt();
            if (choice == 1 || choice == 2) {
                break;
            } else {
                System.out.println("wrong choice , please select again. ");
            }
        }

        Client client = new Client();
        switch (choice) {
            case 1:
                snakeAndLadderGame=client.defaultConfiguration(snakeAndLadderGame);
                break;
            case 2:
                snakeAndLadderGame=client.customeConfiguration( scan);
                break;
            default:
                break;
        }

        System.out.print("Enter number of Players: ");
        int noOfPlayers = scan.nextInt();
        int i = 1;
        while (noOfPlayers > 0) {
            System.out.print("Enter name of Player " + i + ": ");
            i++;
            String player = scan.next();
            snakeAndLadderGame.getPlayersturn().add(new Player(player, 1));
            noOfPlayers--;
        }


        snakeAndLadderGame.startGame();


    }

    private SnakeAndLadderGame customeConfiguration( Scanner scan) {
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        System.out.print("enter number of dice: ");
        int diceCount = scan.nextInt();

        System.out.print("enter board Size: ");
        int boardSize = scan.nextInt();

        snakeAndLadderGame = new SnakeAndLadderGame(boardSize, diceCount);

        System.out.print("Enter number of snake: ");
        int noOfSnakes = scan.nextInt();
        int i = 1;
        while (noOfSnakes > 0) {
            System.out.print("Enter start position of snake " + i + ": ");
            int startPosition = scan.nextInt();
            System.out.print("Enter end position of snake " + i + ": ");
            int endPosition = scan.nextInt();
            i++;
            snakeAndLadderGame.getBoard().addSnake(startPosition, endPosition);
            noOfSnakes--;
        }
        System.out.print("Enter number of ladder: ");
        i = 1;
        int noOfLadders = scan.nextInt();
        while (noOfLadders > 0) {

            System.out.print("Enter start position of snake " + i + ": ");
            int startPosition = scan.nextInt();
            System.out.print("Enter end position of snake " + i + ": ");
            int endPosition = scan.nextInt();
            i++;
            snakeAndLadderGame.getBoard().addLadder(startPosition, endPosition);
            noOfLadders--;
        }
        return  snakeAndLadderGame;
    }

    private SnakeAndLadderGame defaultConfiguration(SnakeAndLadderGame snakeAndLadderGame) {

        /***********Default input****************/
        snakeAndLadderGame = new SnakeAndLadderGame(Constants.BOARD_SIZE, Constants.INITIAL_POSITION);
        for (int[] snake:Constants.SNAKES) {
            snakeAndLadderGame.getBoard().addSnake(snake[0],snake[1]);
        }
        for (int[] ladders:Constants.LADDERS) {
            snakeAndLadderGame.getBoard().addLadder(ladders[0], ladders[1]);
        }
        return snakeAndLadderGame;
    }
}

