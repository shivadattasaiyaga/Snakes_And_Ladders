package Snake_and_Ladders;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import timer.*;

public class Game {
    public Board board;
    Queue<Player> players;
    Dice dice;
    int no_of_players;
    Scanner in = new Scanner(System.in);
    public Game(int max_size,int no_of_dice,int no_of_players){
        board = new Board(max_size);
        players = new LinkedList<>();
        dice = new ActualDice(no_of_dice);
        this.no_of_players = no_of_players;
        addingSnakes();
        addingLadders();
        addingPlayers();
    }
    public void addingSnakes(){
        board.addSnakes(32, 10);
        board.addSnakes(36, 6);
        board.addSnakes(48, 26);
        board.addSnakes(62, 18);
        board.addSnakes(88, 24);
        board.addSnakes(95, 56);
        board.addSnakes(99, 1);
    }
    public void addingLadders(){
        board.addLadders(2, 38);
        board.addLadders(4, 14);
        board.addLadders(8, 30);
        board.addLadders(21, 42);
        board.addLadders(28, 76);
        board.addLadders(50, 67);
        board.addLadders(71, 92);
        board.addLadders(80, 98);
    }
    public void addingPlayers(){
        for(int i=0;i<no_of_players;i++){
            System.out.println("Enter the player "+(i+1)+" name.");
            String name = in.next();
            Player player = new Player(name,"p"+(i+1));
            players.add(player);
        }
    }
    public void startGame(){
        ArrayList<Player> winners = new ArrayList<>();
        int rank = 1;
        Timer timer = new Timer();
        System.out.print("Press enter to roll the dice");
        timer.timer();
        in.nextLine();
        while(players.size()>1){
            Player player = players.poll();
            System.out.println(player.getName() + "'s turn --->");
            in.nextLine();
            int currPos = player.getLoc();
            int diceValue = dice.rollDice();
            if(currPos+diceValue==board.max_size){
                player.setRank(rank++);
                player.setLoc(currPos+diceValue);
                System.out.println(player.getName() + " is at position "+ player.getLoc() + ", and reached goal.");
                System.out.println(); 
                winners.add(player);
            }
            else{
                board.checkSnakeOrLadder(player, diceValue);
                players.add(player);
            }
        }
        winners.add(players.poll());
        System.out.print("Game Over");
        timer.timer();
        System.out.println();
        System.out.println("===================================RANK BOARD===========================");
        System.out.println("PLAYER                     RANK");
        System.out.println("______                     ____");
        System.out.println();
        int i;
        for(i=0;i<winners.size()-1;i++){
            System.out.println(winners.get(i).getName()+"                            "+winners.get(i).getRank());
        }
        System.out.println(winners.get(i).getName()+"                            "+winners.get(i).getRank());
    }

}
