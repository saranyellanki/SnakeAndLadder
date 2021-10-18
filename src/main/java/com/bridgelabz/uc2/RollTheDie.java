package com.bridgelabz.uc2;

import java.util.Random;

public class RollTheDie {

    public static int rollDie() {
        Random random = new Random();
        return random.nextInt(6)+1;
    }

    public static void main(String[] args) {

        System.out.println(rollDie());
    }
}
