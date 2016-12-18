package classesf;

/**
 * Created by pober on 20.11.2016.
 */
public class Archer implements Warrior { //хорошо бы вынести общее поведение в абстрактный класс
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
        if (this.health<0) this.health =0; //неотформатированный код
    }

    public boolean isAlive(){
        if (this.health>0) return true; //просто return health > 0.
        return false;
    }

    public void setSquadName(String name){
        squad.setName(name);
    }

    public Object clone(){
        try {
            Archer archer = (Archer) super.clone();
            archer.name = new String(this.name); //бесполезно создавать строку конструктором
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
