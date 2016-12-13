package classesf;

/**
 * Created by pober on 20.11.2016.
 */
public interface Warrior extends Cloneable {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    void setSquadName(String name);
    Object clone();
    int getHealth();
}
