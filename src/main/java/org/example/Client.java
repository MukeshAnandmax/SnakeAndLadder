package org.example;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        SnakeAndLadderGame snakeAndLadderGame=new SnakeAndLadderGame();
       boolean flag =true;
       int choice=0;
       while(flag){

        System.out.println("Select the option");
        System.out.println("----------------------------------------------------------------------------");
           System.out.println("you want to play with default configuration?: [1]");
        System.out.println("you want to add your snake , ladder , number of dice and board size?: [2]");

        System.out.println("----------------------------------------------------------------------------");
        System.out.print("choice: ");
            choice = scan.nextInt();
           if(choice==1 || choice==2){
               break;
           }else{
               System.out.println("wrong choice , please select again. ");
           }


       }
        if(choice==2) {

            System.out.print("enter number of dice: ");
            int diceCount = scan.nextInt();

            System.out.print("enter board Size: ");
            int boardSize = scan.nextInt();

            snakeAndLadderGame = new SnakeAndLadderGame(boardSize,diceCount);

            System.out.print("Enter number of snake: ");
            int noOfSnakes = scan.nextInt();
            int i = 1;
            while (noOfSnakes > 0) {
                System.out.print("Enter start position of snake " + i+": ");
                int startPosition = scan.nextInt();
                System.out.print("Enter end position of snake " + i+": ");
                int endPosition = scan.nextInt();
                i++;
                snakeAndLadderGame.getBoard().addSnake(startPosition, endPosition);
                noOfSnakes--;
            }
            System.out.print("Enter number of ladder: ");
            i = 1;
            int noOfLadders = scan.nextInt();
            while (noOfLadders > 0) {

                System.out.print("Enter start position of snake " + i+": ");
                int startPosition = scan.nextInt();
                System.out.print("Enter end position of snake " + i+": ");
                int endPosition = scan.nextInt();
                i++;
                snakeAndLadderGame.getBoard().addLadder(startPosition, endPosition);
                noOfLadders--;
            }




        } else if (choice==1) {
            /***********Default input****************/

            snakeAndLadderGame = new SnakeAndLadderGame(100,1);

            snakeAndLadderGame.getBoard().addLadder(51,87);
            snakeAndLadderGame.getBoard().addLadder(11,47);
            snakeAndLadderGame.getBoard().addLadder(15,55);
            snakeAndLadderGame.getBoard().addSnake(10,4);
            snakeAndLadderGame.getBoard().addSnake(32,13);
            snakeAndLadderGame.getBoard().addSnake(67,9);
            snakeAndLadderGame.getBoard().addSnake(68,8);
            snakeAndLadderGame.getBoard().addSnake(97,3);


        }

        System.out.print("Enter number of Players: ");
        int noOfPlayers = scan.nextInt();
        int i=1;
        while(noOfPlayers>0){
            System.out.print("Enter name of Player"+i+": ");
            i++;
            String player = scan.next();
            snakeAndLadderGame.getPlayersturn().add(new Player(player,1));
            noOfPlayers--;
        }


        snakeAndLadderGame.startGame();




    }
}

