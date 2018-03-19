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
  
  //constructors
  public RaceVenue(){
    track = new RaceTrack();
    carInformation = new Text();
    this.musicFile = "";
    this.venueName = "Awakenings";
  }
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
  // Takes the canvas size, and draws the race track with an inner and outer circle.
  // Returns the drawn track.
  public Group drawVenue(int canvasWidth,int canvasHeight){
    Group g = new Group();
    Ellipse e1 = new Ellipse(canvasWidth/2,canvasHeight/2,(canvasWidth*2)/3,(canvasHeight*2)/3);
    Ellipse e2 = new Ellipse(canvasWidth/2,canvasHeight/2,canvasWidth/3,canvasHeight/3);
    e1.setFill(Color.BROWN);
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