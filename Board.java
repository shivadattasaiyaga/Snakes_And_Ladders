package Snake_and_Ladders;

import java.util.*;

public class Board {
    int max_size;
    HashMap<Integer,Integer> snakes;
    HashMap<Integer,Integer> ladders;
    public Board(int max_size){
        this.max_size = max_size;
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }
    public void addSnakes(int snakeHead, int snakeTail){
        snakes.put(snakeHead,snakeTail);
    }
    public void addLadders(int ladderStart, int ladderEnd){
        ladders.put(ladderStart,ladderEnd);
    }
    public void checkSnakeOrLadder(Player player, int diceValue){
        int check_val = diceValue+player.getLoc();
        if(check_val>max_size){
            System.out.println(player.getName() + " requires only " + (max_size-player.getLoc()));
            System.out.println(); 
        }
        else if(snakes.containsKey(check_val)){
            player.setLoc(snakes.get(check_val));
            System.out.println("Oops...! " + player.getName() + " bit by snake at position " + check_val + ", pushed down to position " + snakes.get(check_val));
            System.out.println(); 
        }
        else if(ladders.containsKey(check_val)){
            player.setLoc(ladders.get(check_val));
            System.out.println("Yeah...! " + player.getName() + " got ladder at position " + check_val + ", climbed to position " + ladders.get(check_val));
            System.out.println(); 
        }
        else{
            System.out.println(player.getName() + " is at position " + check_val);
            System.out.println(); 
            player.setLoc(check_val);
        }
    }
}
