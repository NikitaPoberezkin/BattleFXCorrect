package classesf;

/**
 * Created by pober on 20.11.2016.
 */
public class Archer implements Warrior {
    private String name;
    private int health;
    private int damage;
    private Squad squad;

    public Archer(String name, Squad squad){
        this.name = name;
        this.health = 130;
        this.damage = 120;
        this.squad = squad;
    }

    @Override
    public String toString ()
    {
        return "Лучник " + this.name;
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
            Archer archer = (Archer) super.clone();
            archer.name = new String(this.name);
            return archer;
        }
        catch (CloneNotSupportedException e){
            throw new UnsupportedOperationException(e);
        }
    }

    public int getHealth(){
        return this.health;
    }
}
