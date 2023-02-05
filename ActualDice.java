package Snake_and_Ladders;

import java.util.Random; 

public class ActualDice implements Dice {
    int no_of_dice;
    public ActualDice(int no_of_dice){
        this.no_of_dice = no_of_dice;
    }
    public int rollDice(){
        Random random = new Random();
        int turn = 0;
        if(no_of_dice==1){
            // Checking for 3 continous 6s 
            // and checking this only for single dice because don't know logic for multiple dice..
            turn += random.nextInt(6) + 1;
            if (turn == 6) turn += random.nextInt(6) + 1;
            if (turn == 12) turn += random.nextInt(6) + 1;
	        if (turn == 18) return 0;
            return turn;
        }
        else{
            for(int i=0;i<no_of_dice;i++){
                turn += random.nextInt(6)+1; 
            }
            return turn;
        }
    }
}
