import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    this.musicFile = "";
    this.venueName = "Awakenings";
  }
  public RaceVenue(String musicFile, String venueName){
    this.musicFile = musicFile;
    this.venueName = venueName;
    soundTrack = new Media(new File(musicFile).toURI().toString());
    mediaPlayer = new MediaPlayer(soundTrack);
    mediaPlayer.play();
  }
  
  public String getMusicFile(){
   return musicFile; 
  }
  
  public String getVenueName(){
    return venueName;
  }
  
}