import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RaceTrackGUI extends Application{
  
  private RaceVenue venue;
  private Button startButton;
  private Text winner;
  private Text title;
  private Alert  raceFinish;
  private Timeline timer;
  private boolean started;
  private BorderPane bp;
  
  
  public void start(Stage start){
    venue = new RaceVenue();
    started = false;
    startButton = new Button("Start");
    VBox carInfo = new VBox(drawCarPane());
     raceFinish = new Alert(AlertType.CONFIRMATION,"The race is over!");
    winner = new Text();
    title = new Text(); //title of the game
    
    timer = new Timeline(new KeyFrame( Duration.millis(1),new EventHandler<ActionEvent>(){
      @Override public void handle(ActionEvent actionEvent){
        drive();
        carInfo.getChildren().clear();
        carInfo.getChildren().add(drawCarPane());
        if(venue.getTrack().checkWinner()){
          timer.pause();
          System.out.println(venue.getTrack().getWinner());
          raceFinish.setContentText("The race is over!\nThe winner is: "+venue.getTrack().getWinner().getName());
          raceFinish.show();
        }
      }}));
    timer.setCycleCount(Animation.INDEFINITE);
    
    Group g = new Group(venue.drawVenue(600,400));
    g.getChildren().add(venue.draw());
    
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
    
    //add title of the game, changes the font size and color followed by a stroke.
    title.setText("Top Gear");
    title.setTranslateX(480);
    title.setTranslateY(20);
    title.setFill(Color.GREEN);
    title.setFont(Font.font ("Verdana", FontWeight.BOLD, 80));
    title.setStroke(Color.YELLOW);
    title.setStrokeWidth(3);
    
    bp = new BorderPane();
    bp.setCenter(g);
    bp.setRight(buttons);
    bp.setLeft(carInfo);
    bp.setTop(title);
    Scene scene = new Scene(bp,1300,720);   
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }
  
  private void drive(){
    venue.getTrack().moveCars();
  }
  
  private Group drawCarPane(){
    Text carInfo = new Text();
    Rectangle mainBox = new Rectangle(0,25,300,450);
    mainBox.setFill(Color.LIGHTBLUE);
    mainBox.setStroke(Color.BLACK);
    mainBox.setTranslateX(-25);
    Rectangle boxes[] = new Rectangle[venue.getTrack().getCarTotal()];
    Group group = new Group(mainBox);
    for(int i = 0; i < venue.getTrack().getCarTotal();i++){
      boxes[i] = new Rectangle(0,(112*i)+50,250,70);
      boxes[i].setFill(Color.LIGHTGREY);
      boxes[i].setStroke(Color.BLACK);
      carInfo.setText(carInfo.getText() + "\n\n\n\n" + venue.getTrack().getCar(i).toString());
      group.getChildren().add(boxes[i]);
    }
    group.getChildren().add(carInfo);
    return group;
  }  
  
  public static void main(String args[]){
    launch(args);
  }
}