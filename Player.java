package Snake_and_Ladders;

public class Player {
    private String name;
    private String id;
    private int loc = 0;
    private int rank;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setLoc(int loc){
        this.loc = loc;
    }
    public int getLoc(){
        return this.loc;
    }
    public void setRank(int rank){
        this.rank = rank;
    }
    public int getRank(){
        return this.rank;
    }
    public Player(String name, String id){
        setName(name);
        setId(id);

    }
}
