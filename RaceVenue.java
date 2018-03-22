/*
 * This is the RaceVenue class
 * The main purpose of this class is to have a venue so cars can race on
 * The RaceVenue will have the name of the venue, a RaceTrack object.
 * This class draws the RaceVenue with two Ellipse shape objects
 * It will also have information about the cars that will race here.
 * The venue will be playing music to entertain the users while they race.
 * 
 */
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.scene.shape.Ellipse;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import java.io.File;

public class RaceVenue{
 
  private RaceTrack track;
  private String musicFile;
  private Text carInformation;
  private String venueName;
  
  private Media soundTrack;
  private MediaPlayer mediaPlayer;
  
  //code by Alex
  //no arg constructor
  public RaceVenue(){
    track = new RaceTrack();
    carInformation = new Text();
    this.musicFile = "Top Gear Music.mp3";
    this.venueName = "Awakenings";
    soundTrack = new Media(new File(musicFile).toURI().toString()); //creates a sound track
    mediaPlayer = new MediaPlayer(soundTrack); //adds to  the media player
    mediaPlayer.play(); //plays the media
  }
  //code by Alex
  //parameterized constructor
  public RaceVenue(String musicFile, String venueName){
    this.musicFile = musicFile;
    this.venueName = venueName;
    soundTrack = new Media(new File(musicFile).toURI().toString());
    mediaPlayer = new MediaPlayer(soundTrack);
    mediaPlayer.play();
    track = new RaceTrack();
    carInformation = new Text();
  }
  
  public String getMusicFile(){
   return musicFile; 
  }
  
  public String getVenueName(){
    return venueName;
  }
//   Takes the canvas size, and draws the race track with an inner and outer circle.
//   Returns the drawn track.
  //code by Martin
  public Group drawVenue(int canvasWidth,int canvasHeight){
    Group g = new Group();
    Ellipse e1 = new Ellipse(canvasWidth/2,canvasHeight/2,(canvasWidth*2)/3,(canvasHeight*2)/3);
    Ellipse e2 = new Ellipse(canvasWidth/2,canvasHeight/2,canvasWidth/4,canvasHeight/4);
    e1.setFill(Color.BLACK);
    e2.setFill(Color.GREEN);
    g.getChildren().add(e1);
    g.getChildren().add(e2);
   return g;                     
  }
  public RaceTrack getTrack(){
    return track;
  }
  
  public Group draw(){
    return track.drawTrack();
  }
 }