package com.bridgelabz.uc7;

import com.bridgelabz.uc1.InitialPositionOfPlayer;

import java.util.Random;

class Dice{

    public int dieRoll() {
        Random random = new Random();
        return random.nextInt(6)+1;
    }

}
public class ResultOfTheGame {

    final static int NO_PLAY = 1;
    final static int LADDER = 2;
    final static int SNAKE = 3;

    public static int check() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    public static void main(String[] args) {

        int dieRolls = 0;
        boolean is_player_1 = true;
        int player1 = 0;
        int player2 = 0;

        InitialPositionOfPlayer positionObj = new InitialPositionOfPlayer();
        Dice dice = new Dice();


        while (player1 < 100 && player2 < 100) {
            int die_number = dice.dieRoll();

            switch (check()) {
                case NO_PLAY:
                    break;
                case LADDER:
                    if (is_player_1) {
                        if (player1 + die_number <= 100) {
                            player1 += die_number;
                            is_player_1 = false;
                        }
                    } else if (player2 + die_number <= 100) {
                        player2 += die_number;
                        is_player_1 = true;
                    }
                    break;
                case SNAKE:
                    if (is_player_1) {
                        if (player1 - die_number >= 0) {
                            player1 -= die_number;
                        } else
                            player1 = 0;
                    } else if (player2 - die_number >= 0) {
                        player2 -= die_number;
                    } else
                        player2 = 0;
                    break;
            }
            is_player_1 = !is_player_1;
            System.out.println("Position of Player1 : " + player1);
            System.out.println("Position of Player2 : " + player2);
            }
            if (player1 == 100)
                System.out.println("Player1 Won the game");
            else if (player2 == 100)
                System.out.println("Player2 Won the game");
        }
    }
