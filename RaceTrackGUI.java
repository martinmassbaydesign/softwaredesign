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
  private boolean started;
  
  public void start(Stage start){
    venue = new RaceVenue();
    started = false;
    startButton = new Button("Start");
    
    startButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event){
        timer.play();
        System.out.println("beep");
        started = true;
        if(started)
          venue.getTrack().startAgain();
      }
    }));
    winner = new Text();
    timer = new Timeline(new KeyFrame( Duration.millis(50),new EventHandler<ActionEvent>(){
      @Override public void handle(ActionEvent actionEvent){
        drive();
        System.out.println("boop");
        if(venue.getTrack().checkWinner()){
          timer.pause();
          System.out.println(venue.getTrack().getWinner());
        }
      }}));
    timer.setCycleCount(Animation.INDEFINITE);
    
    
 
    
    //  raceFinish = new Alert("The race is over!");
    
    Group g = new Group(venue.drawVenue(600,400));
    g.getChildren().add(venue.draw());
    g.setTranslateX(100);
    g.setTranslateY(100);
    g.getChildren().add(startButton);
    
    Scene scene = new Scene(g,1000,600);   
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