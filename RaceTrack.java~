import java.util.ArrayList;
import java.util.Timer;
import javafx.scene.Group;

public class RaceTrack {
  
  private ArrayList<Car> cars;
  private ArrayList<Location> locations;
  private Timer clock; 
  
  private int lap;
  
  public RaceTrack(){
    this.lap = 4;
    cars = new ArrayList<Car>();
    locations = new ArrayList<Location>();
  }
  
  public RaceTrack(int lap){
    this.lap = lap;
  }
  
  public Car getWinner(){
    if(checkWinner()){
      for(int i =0; i<cars.size(); i++){
        if(getCar(i).getLocations() >=lap){
          return getCar(i);
        }
      }
    }
    return null;
  }
  
  public void moveCars(){
    for(int i = 0; i < cars.size();i++){
      if(getCar(i).getX() <getNext(i).getX()){
        getCar(i).moveX(1);
      }
      else if(getCar(i).getX() > getNext(i).getX()){
        getCar(i).moveX(-1);
      }
      if(getCar(i).getY() <getNext(i).getY()){
        getCar(i).moveY(1);
      }
      else if(getCar(i).getY() > getNext(i).getY()){
        getCar(i).moveY(-1);
      }
    }
  }
  
  
  //checks for winner if the car location is greater than 4
  public boolean checkWinner(){
    for(int i =0; i<cars.size(); i++){
      if(getCar(i).getLocations() >= lap)
        return true;
    }
    return false;
  }
  
  public Group drawTrack(){
    Group g = new Group();
    for(Car c : cars){ g.getChildren().add(c.draw());}
    for(Location l : locations){ g.getChildren().add(l.draw());}
    return g;
  }
  
  public Car getCar(int carNum){
    return cars.get(carNum);
  }
  
  public Location getLocation(int locationNum){
    return locations.get(locationNum);
    
  }
  
  public String getTime(){
    return "The time is: " + clock;
  }
  
  public void startTimer(){
    clock.start();
  }
  
  private Location getNext(int index){
    return getLocation((index+getCar(index).getLocations())%lap);
  }
  
}

