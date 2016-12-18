package classesf;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pober on 20.11.2016.
 */
public class Squad implements Cloneable {
    private ArrayList<Warrior> warriors;
    private String name;

    public void AddWarrior(Warrior warrior){ //имена методов принято писать с маленькой буквы
        warriors.add(warrior);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Squad(String name){
        this.name = name;
        ArrayList<Warrior> warriors = new ArrayList<>();
        this.warriors = warriors;
    }

    public Warrior getRandomWarrior(){
        Random rand = new Random();
        int random_warrior;
        while (true) {
            random_warrior = rand.nextInt(this.warriors.size());
            if (this.warriors.get(random_warrior).isAlive()) return this.warriors.get(random_warrior); //не надо писать это в одну строку
        }
    }

    public boolean hasAliveWarriors(){
        for (int i=0; i<warriors.size(); i++){ //foreach смотрится лучше
            if (warriors.get(i).isAlive()) return true;
        }
        return false;
    }

    public String toString(){
        //return "Отряд " + this.name; реализация, требуемая в задании(немного дополнил ее для удобства)
        String string = "";
        for (int i=0; i<warriors.size(); i++){
            string+=warriors.get(i).toString() + "( " + warriors.get(i).attack() + " dmg, " + warriors.get(i).getHealth()+ " hp)" +" \n"; //нельзя складывать строки в цикле. использовать StringBuilder
        }
        return "Отряд " + this.name +"\n" + string + "\n";
    }

    public Object clone(){
        try{
            Squad squad = (Squad) super.clone();
            squad.name = new String(this.name);
            squad.warriors = new ArrayList<Warrior>();
            for (int i=0; i<warriors.size(); i++){
                squad.warriors.set(i,(Warrior) this.warriors.get(i).clone()); //set в пустой список? тут упадет IndexOutOfBoundsException
            }
            return squad;
        }
        catch (CloneNotSupportedException e){
            throw new UnsupportedOperationException(e);
        }
    }

    /*public void setWarriors(classesf.Warrior[] warriors){ненужный код нужно удалять, а не комментировать
        this.warriors = warriors;
    }

    public classesf.Warrior[] getWarriors(){
        return this.warriors;
    }*/
}
