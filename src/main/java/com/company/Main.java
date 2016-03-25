package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board player1 = new Board();
        Board player2 = new Board();

        // ask player 1 to initialize their board
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, please initialize your board.");
        while(player1.getShips() != null) {
            try {
                Integer[] i = new Integer[player1.getBsize()];
                System.out.println("Enter 5 numbers from -1 to 2, where -1 means no ship:");
                for (Integer j = 0; j < player1.getBsize(); j++) {
                    i[j] = scanner.nextInt();
                }
                scanner.nextLine();
                player1.init(i);
                break;

            } catch (Exception e) {
                if (e.getClass() == boardException.class) {
                    System.err.println("Incorrect board data: " + e.getMessage());
                } else {
                    System.err.println("Player 1, I didn't understand your input, please try again.");
                    System.exit(0);
                }
            }
        }
        System.out.println("Thanks!\n");

        // ask player 2 to initialize their board
        System.out.println("Player 2, please initialize your board.");
        while(player2.getShips() != null) {
            try {
                Integer[] i = new Integer[player2.getBsize()];
                System.out.println("Enter 5 numbers from -1 to 2, where -1 means no ship:");
                for (Integer j = 0; j < player2.getBsize(); j++) {
                    i[j] = scanner.nextInt();
                }
                scanner.nextLine();
                player2.init(i);
                break;

            } catch (Exception e) {
                if (e.getClass() == boardException.class) {
                    System.err.println("Incorrect board data: " + e.getMessage());
                } else {
                    System.err.println("Player 2, I didn't understand your input, please try again.");
                    System.exit(0);
                }
            }
        }
        System.out.println("Thanks!\n");

        // ok we have two boards. now we are ready to play
        // now ping pong back and forth until we get an ALL_SUNK

    }
}
