package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import classesf.Squad;
import classesf.Archer;
import classesf.Warlock;
import classesf.SwordMaster;
import classesf.Battle;
import classesf.DateHelper;
import classesf.Warrior;

import java.util.ArrayList;
import java.util.Observable;

public class Controller{
    private Squad squad_one;
    private Squad squad_two;

    @FXML
    private TextField first_squad_name;
    @FXML
    private TextField second_squad_name;
    @FXML
    private TextArea squad1;
    @FXML
    private TextArea squad2;
    @FXML
    private Button btn;
    @FXML
    private Button addbtn;
    @FXML
    private ChoiceBox types_of_warriors;
    @FXML
    private ChoiceBox squad_number;
    @FXML
    TextField warrior_name;
    @FXML
    Button create_squad;
    @FXML
    Button fight;
    @FXML
    TextArea battle_log;

    @FXML
    public void initialize(){
        ObservableList<String> types = FXCollections.observableArrayList();
        types.add("Warlock (150dmg 100hp)");
        types.add("SwordMaster (100dmg 150hp)");
        types.add("Archer (120dmg 130hp)");
        types_of_warriors.setItems(types);
        types_of_warriors.getSelectionModel().select(0);
        ObservableList<String> squadnum = FXCollections.observableArrayList();
        squadnum.add("First Squad");
        squadnum.add("Second Squad");
        squad_number.setItems(squadnum);
        squad_number.getSelectionModel().select(0);
    }

    public void createSquads(){
        squad_one = new Squad(first_squad_name.getText());
        squad_two = new Squad(second_squad_name.getText());
        squad1.setText(squad_one.toString());
        squad2.setText(squad_two.toString());
    }

    public void updateInfo(){
        squad1.setText(squad_one.toString());
        squad2.setText(squad_two.toString());
    }

    public void addWarrior(){
        switch (squad_number.getSelectionModel().getSelectedIndex() ){
            case 0:
                switch (types_of_warriors.getSelectionModel().getSelectedIndex()){
                    case 0:
                        squad_one.AddWarrior(new Warlock(warrior_name.getText(), squad_one));
                        squad1.setText(squad_one.toString());
                        break;
                    case 1:
                        squad_one.AddWarrior(new SwordMaster(warrior_name.getText(), squad_one));
                        squad1.setText(squad_one.toString());
                        break;
                    case 2:
                        squad_one.AddWarrior(new Archer(warrior_name.getText(), squad_one));
                        squad1.setText(squad_one.toString());
                        break;
                }
                break;
            case 1:
                switch (types_of_warriors.getSelectionModel().getSelectedIndex()){
                    case 0:
                        squad_two.AddWarrior(new Warlock(warrior_name.getText(), squad_two));
                        squad2.setText(squad_two.toString());
                        break;
                    case 1:
                        squad_two.AddWarrior(new SwordMaster(warrior_name.getText(), squad_two));
                        squad2.setText(squad_two.toString());
                        break;
                    case 2:
                        squad_two.AddWarrior(new Archer(warrior_name.getText(), squad_two));
                        squad2.setText(squad_two.toString());
                        break;
                }
                break;
        }
    }

    public void goFight(){
        Battle.oneBattle(squad_one,squad_two);
        battle_log.setText(Battle.getBattle_log());
    }
}