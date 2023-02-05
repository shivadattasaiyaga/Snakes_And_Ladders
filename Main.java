package Snake_and_Ladders;

import java.util.Scanner;
import timer.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("                  Welcome to the Snake and Ladders Game");
        Timer timer = new Timer();
        timer.timer();
        System.out.println("Enter the no of cells in board.");
        int max_size = in.nextInt();
        System.out.println("Enter the no of dices.");
        int no_of_dice = in.nextInt();
        System.out.println("Enter the no of players.");
        int no_of_players = in.nextInt();
        Game game = new Game(max_size, no_of_dice, no_of_players);
        System.out.print("Be ready, starting the game.");
        timer.timer();
        game.startGame();
        in.close();
    }
}
