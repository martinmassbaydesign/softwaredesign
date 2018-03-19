import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;


public class RaceTrackGUI extends Application{
  
  private RaceVenue venue;
  private Button startButton;
  private Text winner;
  private Alert  raceFinish;
  
  public void start(Stage start){
    venue = new RaceVenue();
    startButton = new Button("Start");
    winner = new Text();
  //  raceFinish = new Alert("The race is over!");
    
    Group g = new Group(venue.draw());
    Scene scene = new Scene(g);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }

  
  
  
  
  
  
  
  public static void main(String args[]){
    launch(args);
  }
}