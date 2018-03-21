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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RaceTrackGUI extends Application{
  
  private RaceVenue venue;
  private Button startButton;
  private Text winner;
  private Alert  raceFinish;
  private Timeline timer;
  private boolean started;
  private BorderPane bp;
  
  
  public void start(Stage start){
    venue = new RaceVenue();
    started = false;
    startButton = new Button("Start");
    VBox carInfo = new VBox(drawCarPane());
    
    winner = new Text();
    timer = new Timeline(new KeyFrame( Duration.millis(50),new EventHandler<ActionEvent>(){
      @Override public void handle(ActionEvent actionEvent){
        drive();
        carInfo.getChildren().clear();
        carInfo.getChildren().add(drawCarPane());
//        System.out.println("boop");
        if(venue.getTrack().checkWinner()){
          timer.pause();
          System.out.println(venue.getTrack().getWinner());
        }
      }}));
    timer.setCycleCount(Animation.INDEFINITE);
    
    
    
    
    //  raceFinish = new Alert("The race is over!");
    
    Group g = new Group(venue.drawVenue(600,400));
    g.getChildren().add(venue.draw());
//    g.setTranslateX(100);
//    g.setTranslateY(100);
    
    startButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event){
        if(started){
          venue.getTrack().startAgain();
          g.getChildren().remove(venue.draw());
          g.getChildren().add(venue.draw());
        }
        
        timer.play();
        System.out.println("beep");
        
        
        started = true;
      }
    }));
    
    Button pause = new Button("pause");
    VBox buttons = new VBox(startButton,pause);
    
    buttons.setTranslateX(-50);
    buttons.setTranslateY(50);
    carInfo.setTranslateX(50);
    //g.getChildren().add(startButton);
    bp = new BorderPane();
    bp.setCenter(g);
    bp.setRight(buttons);
    bp.setLeft(carInfo);
    Scene scene = new Scene(bp,1300,720);   
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }
  
  private void drive(){
    venue.getTrack().moveCars();
  }
  
  private Text drawCarPane(){
    Text carInfo = new Text();
    for(int i = 0; i < venue.getTrack().getCarTotal();i++){
      carInfo.setText(carInfo.getText() + "\n\n\n\n" + venue.getTrack().getCar(i).toString());
    }
    return carInfo;
  }  
  

    
  
  public static void main(String args[]){
    launch(args);
  }
}