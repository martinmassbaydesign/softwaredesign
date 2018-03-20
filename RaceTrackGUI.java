import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent; 
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.util.Duration;
import javafx.animation.Animation;

public class RaceTrackGUI extends Application{
  
  private RaceVenue venue;
  private Button startButton;
  private Text winner;
  private Alert  raceFinish;
  private Timeline timer;
  
  public void start(Stage start){
    venue = new RaceVenue();
    startButton = new Button("Start");
        startButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event){
        timer.play();
        System.out.println("beep");
      }
    }));
    winner = new Text();
    timer = new Timeline(new KeyFrame( Duration.millis(100),new EventHandler<ActionEvent>(){
      @Override public void handle(ActionEvent actionEvent){
        drive();
        System.out.println("boop");
      }}));
    timer.setCycleCount(Animation.INDEFINITE);
    
 
  //  raceFinish = new Alert("The race is over!");
    
    Group g = new Group(venue.draw());
    g.getChildren().add(startButton);
    
    Scene scene = new Scene(g,600,300);   

    
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }

  
  private void drive(){
    
    venue.getTrack().moveCars();
  }
  
  
  
  
  public static void main(String args[]){
    launch(args);
  }
}