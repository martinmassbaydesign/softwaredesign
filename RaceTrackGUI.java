/**
 * RaceTrackGUI.java
 * This is the GUI for a race track that is a creation between Cars and Locations. The RaceTrack is the main class for that
 * And then the Venue slaps it all together, draws the actual track, and plays music.
 * 
 */

// FX general setup stuff.
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.application.Application;
// Popups
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
// Text stuff
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
// Shapes to draw boxes.
import javafx.scene.shape.Rectangle;

// Buttons
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent; 
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
//Animation stuff to do clock and redraws.
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.util.Duration;
import javafx.animation.Animation;
// Layout stuff
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class RaceTrackGUI extends Application{
  
  private RaceVenue venue;
  private Button startButton;
  private Text winner;
  private Text title;
  private Alert  raceFinish;
  private Timeline timer;
  private boolean started;
  private BorderPane bp;
  
  // Start method
  public void start(Stage start){
    
    venue = new RaceVenue(); // Creat the venue
    started = false; // say that the program has not started.
    VBox carInfo = new VBox(drawCarPane()); // Draw the car info pane on the left.
    raceFinish = new Alert(AlertType.CONFIRMATION,"The race is over!");
    winner = new Text();
    title = new Text(); //title of the game
    // Make the primary group and add the track to it.
    Group g = new Group(venue.drawVenue(600,400));
    // Add the cars and locations to the track
    g.getChildren().add(venue.draw());
    
    
    //************************************* Timer stuff ******************************************************* 
    
// adds a clock that ticks at 50milliseconds, every tick it redraws all the car info and cars. 
    // Code by Martin
    timer = new Timeline(new KeyFrame( Duration.millis(50),new EventHandler<ActionEvent>(){
      @Override public void handle(ActionEvent actionEvent){
        drive();
        carInfo.getChildren().clear();
        carInfo.getChildren().add(drawCarPane());
        // If there is a winner it does a popup and stops the race.
        if(venue.getTrack().checkWinner()){
          timer.pause();
          raceFinish.setContentText("The race is over!\nThe winner is: "+venue.getTrack().getWinner().getName());
          raceFinish.show();
        }
      }}));
    // Tells the timer to loop indefinitely
    timer.setCycleCount(Animation.INDEFINITE);
    
    //************************************* Buttons ***********************************************************
    
    // Start Button - when clicked start the race and mark it as started
    // Afterwards if clicked again will restart the race.
    // Coded by Martin
    startButton = new Button("Start");
    startButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event){
        if(started){
          venue.getTrack().startAgain();
          g.getChildren().remove(venue.draw());
          g.getChildren().add(venue.draw());
        }
        timer.play();
        started = true;
      }}));
    // Pause button - When clicked pauses the timer and will stop the race. Does nothing if race has not started.
    // Coded by Martin.
    Button pause = new Button("pause");
    pause.setOnMouseClicked((new EventHandler<MouseEvent>(){
      public void handle(MouseEvent event){
        if(started){
          timer.pause();
          started = false;
        }}}));
    // Makes the rectangle/box for the buttons to sit in.
    Rectangle buttonBox = new Rectangle(-15,-15,70,80);
    buttonBox.setFill(Color.LIGHTGRAY);
    buttonBox.setStroke(Color.BLACK);
    pause.setTranslateY(30);
    Group buttons = new Group(buttonBox,startButton,pause);
//    VBox buttons = new VBox(new Group(buttonBox,startButton,pause)); 
    buttons.setTranslateX(-50);
    buttons.setTranslateY(50);
    
    
    
    //add title of the game, changes the font size and color followed by a stroke.
    // Code by Alex
    title.setText("Top Gear");
    title.setTranslateX(480);
    title.setTranslateY(20);
    title.setFill(Color.GREEN);
    title.setFont(Font.font ("Verdana", FontWeight.BOLD, 80));
    title.setStroke(Color.YELLOW);
    title.setStrokeWidth(3);
    
    // Sets up the stage and borderPane adds everything together and makes it all juicy good.
    // General code - Martin, Alex, Opie.
    carInfo.setTranslateX(50);
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
  
  // Moves the cars
  // Code by Martin
  private void drive(){
    venue.getTrack().moveCars();
  }
  // Draws the car information and boxes around it.
  // Code by Martin
  private Group drawCarPane(){
    Text carInfo = new Text();
    Rectangle mainBox = new Rectangle(0,25,300,450);
    mainBox.setFill(Color.LIGHTBLUE);
    mainBox.setStroke(Color.BLACK);
    mainBox.setTranslateX(-25);
    Rectangle boxes[] = new Rectangle[venue.getTrack().getCarTotal()];
    Group group = new Group(mainBox);
    // Draws a box for each car, and adds it to the group.
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
  
  
  // start the program - is the main.
  public static void main(String args[]){
    launch(args);
  }
}