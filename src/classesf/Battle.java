package classesf;

/**
 * Created by pober on 22.11.2016.
 */
public class Battle {
    private static String battle_log;

    public static String getBattle_log(){
        return battle_log;
    }
    public static void oneRound(Squad squad1, Squad squad2){
        Warrior warrior1 = squad1.getRandomWarrior();
        Warrior warrior2 = squad2.getRandomWarrior();
        warrior2.takeDamage(warrior1.attack());
        battle_log += warrior1.toString() + " нанес " + warrior2.toString() + " " + warrior1.attack() + " урона\n";
    }

    public static void oneBattle(Squad squad1, Squad squad2){
        battle_log ="";
        battle_log +="В битву вступают 2 отряда!\n";
        battle_log += squad1.toString();
        battle_log += squad2.toString();
        battle_log += "Битва началась \n";
        DateHelper dateHelper = new DateHelper();
        battle_log += dateHelper.getFormattedStartDate() + "\n";
        while (true){
            Battle.oneRound(squad1,squad2);
            battle_log += "\n"+squad1.toString()+squad2.toString();
            dateHelper.skipTime();
            if (!squad2.hasAliveWarriors()){
                battle_log += "\n"+squad1.getName() + " победили, время сражения: " + dateHelper.getFormattedDiff();
                break;
            }
            Battle.oneRound(squad2,squad1);
            battle_log += "\n"+squad1.toString()+squad2.toString();
            dateHelper.skipTime();
            if (!squad1.hasAliveWarriors()){
                battle_log += "\n"+squad2.getName() + " победили, время сражения: " + dateHelper.getFormattedDiff();
                break;
            }
        }
    }

    /*public static classesf.Squad createSquad(){
        String[] warriors_names = {"Вавирон","Гелегил","Боневал","Турин","Беон","Киронтар","Барионбар","Беон","Эльронрн","Белекдил","Экрадор","Бателидил","Ваон","Дирионлор","Тарсил","Эаррибар","Меагтар"};
        String[] squads_names = {"СИНИЕ","ЗЕЛЕНЫЕ","КРАСНЫЕ","ЖЕЛТЫЕ","БЕЛЫЕ","ЧЕРНЫЕ"};
        Random rand = new Random();
        classesf.Squad squad = new classesf.Squad(squads_names[rand.nextInt(squads_names.length)]); // Создание 1 отряда со случайным именем из массива squad_names
        classesf.Warrior[] warriors_squad1 = new classesf.Warrior[squad.getWarriors().length];
        for (int i=0; i<warriors_squad1.length; i++){
            switch (rand.nextInt(3)+1){
                case 1: warriors_squad1[i] = new classesf.Warlock(warriors_names[rand.nextInt(warriors_names.length)], squad); // Добавление в отряд бойца со случайным именем из массива warriors_names
                    break;
                case 2: warriors_squad1[i] = new classesf.Archer(warriors_names[rand.nextInt(warriors_names.length)], squad);
                    break;
                case 3: warriors_squad1[i] = new classesf.SwordMaster(warriors_names[rand.nextInt(warriors_names.length)], squad);
                    break;
            }
        }
        squad.setWarriors(warriors_squad1);
        return squad;
    }*/
}
