import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;

public class cyrillicGeo extends Application {
  private TextField textField = new TextField();
  private Button[] buttons;
  private int startCapital = 1040;
  private int startSmall = 1072;
  private int numberOfLetters = 32;
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 520, 280);
    
    textField.setLayoutX(10);
    textField.setLayoutY(10);
    textField.setPrefHeight(50);
    textField.setPrefWidth(500);
    root.getChildren().add(textField);
    
    buttons =  new Button[numberOfLetters];
    
    for(int i =0; i < numberOfLetters; i++){
      int count = i;
      buttons[i] = new Button( returnUnicode(startCapital + i) + " " + returnUnicode(startSmall + i));
      buttons[i].setLayoutX(10 + ((i%10)* 50));
      buttons[i].setLayoutY(70 + ((i/10)* 50));
      buttons[i].setPrefHeight(50);
      buttons[i].setPrefWidth(50);
      buttons[i].setOnAction(e -> {
        textField.setText(textField.getText() +  returnUnicode(startCapital + count)); 
      });
      root.getChildren().add(buttons[i]);
    }
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("RusAlp");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
  
  private String returnUnicode(int c){
    return Character.toString((char)c);
  }
}

