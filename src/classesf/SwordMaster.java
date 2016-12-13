package classesf;

/**
 * Created by pober on 20.11.2016.
 */
public class SwordMaster implements Warrior{
    private String name;
    private int health;
    private int damage;
    private Squad squad;

    public SwordMaster(String name, Squad squad){
        this.name = name;
        this.health = 150;
        this.damage = 100;
        this.squad = squad;
    }

    @Override
    public String toString ()
    {
        return "Мечник " + this.name;
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
            SwordMaster swordMaster = (SwordMaster) super.clone();
            swordMaster.name = new String(this.name);
            return swordMaster;
        }
        catch (CloneNotSupportedException e){
            throw new UnsupportedOperationException(e);
        }
    }

    public int getHealth(){
        return this.health;
    }
}
