package classesf;

/**
 * Created by pober on 20.11.2016.
 */


public class Warlock implements Warrior{
    private String name;
    private int health;
    private int damage;
    private Squad squad;

    public Warlock(String name, Squad squad){
        this.name = name;
        this.health = 100;
        this.damage = 150;
        this.squad = squad;
    }

    @Override
    public String toString ()
    {
        return "Чернокнижник " + this.name;
    }

    public int attack(){
        return this.damage;
    }

    public void takeDamage(int damage){
        this.health-=damage;
        if (this.health<0) this.health =0;
    }

    public boolean isAlive(){
        if (this.health>0) return true;
        return false;
    }

        public void setSquadName(String name){
            squad.setName(name);
    }

    public Object clone(){
        try {
            Warlock warlock = (Warlock) super.clone();
            warlock.name = new String(this.name);
            return warlock;
        }
        catch (CloneNotSupportedException e){
            throw new UnsupportedOperationException(e);
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHealth(){
        return this.health;
    }
}
