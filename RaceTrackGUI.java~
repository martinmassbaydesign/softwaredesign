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
    g.getChildren().add(startButton);
    
    Scene scene = new Scene(g);   
    startButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event){
        venue.getTrack().moveCars();
        
        Group g = new Group(venue.draw());
        g.getChildren().add(startButton);
        scene.setRoot(g);
        System.out.println("beep");
      }
    }));
    
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }

  
  
  
  
  
  
  
  public static void main(String args[]){
    launch(args);
  }
}