package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Random;

public class PrimaryController {

    @FXML
    private TextArea options;

    @FXML
    private Label requestOptions;

    @FXML
    private Button answerBtn;

    @FXML
    private Button newRequest;

    @FXML
    private Label answerLabel;

    @FXML
    private TextField answerTF;

    @FXML
    private TextField inputTF;

    @FXML
    void getMyAnswer(ActionEvent event) {
        String str = inputTF.getText();
        Random rand = new Random();
        String[] riddles = {"What has to be broken before you can use it?",
                " I’m tall when I’m young, and I’m short when I’m old. What am I?",
        "What can you break, even if you never pick it up or touch it?",
        "What can you keep after giving to someone?",
        "What can’t talk but will reply when spoken to?"};
        if(Objects.equals(str, "What is the day?")){
            answerTF.setText(str + "  " +LocalDate.now().toString());
        }else if (Objects.equals(str, "What is the time?")){
            answerTF.setText(str + "  " + LocalTime.now().toString());
        }else if(Objects.equals(str, "Say hello")){
            answerTF.setText("Hello world!");
        }else if(str.contains("Give me a riddle")){
            answerTF.setText("Your riddle is: "+riddles[rand.nextInt(5)]);
        }else{
            answerTF.setText("Echoing: "+str);
        }
        options.setVisible(false);
        requestOptions.setVisible(false);
        answerLabel.setVisible(true);
        answerTF.setVisible(true);
        newRequest.setVisible(true);
    }

    @FXML
    void setNewRequest(ActionEvent event){
        inputTF.clear();
        answerTF.clear();
        answerTF.setVisible(false);
        answerLabel.setVisible(false);
        options.setVisible(true);
        requestOptions.setVisible(true);
        newRequest.setDisable(true);
    }

    @FXML
    void initialize() {
        answerLabel.setVisible(false);
        answerTF.setVisible(false);
        newRequest.setDisable(true);
        options.setText("What is the day?\nWhat is the time?\n" +
                "Say hello\nGive me a riddle\nanything else will be echo back at you");
        options.setVisible(true);
        requestOptions.setVisible(true);
    }

}
