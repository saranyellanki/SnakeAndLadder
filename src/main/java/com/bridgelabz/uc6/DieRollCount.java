package com.bridgelabz.uc6;

import com.bridgelabz.uc1.InitialPositionOfPlayer;

import java.util.Random;

class Dice {

    public int dieRoll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}

    public class DieRollCount {

        final static int NO_PLAY = 1;
        final static int LADDER = 2;
        final static int SNAKE = 3;

        public static int check() {
            Random random = new Random();
            return random.nextInt(3) + 1;
        }

        public static void main(String[] args) {

            int dieRolls = 0;

            InitialPositionOfPlayer positionObj = new InitialPositionOfPlayer();
            Dice dice = new Dice();


            while (positionObj.position < 100) {
                int die_number = dice.dieRoll();
                dieRolls += 1;

                switch (check()) {
                    case NO_PLAY:
                        break;
                    case LADDER:
                        if (positionObj.position + die_number <= 100) {
                            positionObj.position += die_number;
                        }
                        break;
                    case SNAKE:
                        if (positionObj.position - die_number >= 0) {
                            positionObj.position -= die_number;
                        }
                        break;
                }
            }
            System.out.println("Number of time die rolled is : " + dieRolls);
        }

    }
