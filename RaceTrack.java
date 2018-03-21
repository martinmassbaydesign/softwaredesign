import java.util.ArrayList;
import java.util.Timer;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class RaceTrack {
  
  private ArrayList<Car> cars;
  private ArrayList<Location> locations;

  private int lap;
  
  public RaceTrack(){
    this.lap = 4;
    cars = new ArrayList<Car>();
    locations = new ArrayList<Location>();
    for(int i = 0; i < lap;i++){
      locations.add(new Location());
//      locations.get(i).setCoords((90*((i-1)%2))+180,(90*((i)%3))+180);

      cars.add(new Car(0, 0, Color.RED,"Generic Race car","Generic Model","Car" + i));
      if(i%2 == 0)
          getLocation(i).setCoords(25+(275*i),200);
       if(i%2 == 1)
          getLocation(i).setCoords(300,200*(i-1));
      
        getCar(i).setX(getLocation(i).getX());
        getCar(i).setY(getLocation(i).getY());
    }
  }
  
  public RaceTrack(int lap){
    this.lap = lap;
    cars = new ArrayList<Car>();
    locations = new ArrayList<Location>();
  }
  
  public Car getWinner(){
    if(checkWinner()){
      for(int i =0; i<cars.size(); i++){
        if(getCar(i).getLocationsTouched() >lap){
          return getCar(i);
        }
      }
    }
    return null;
  }
  
  public void moveCars(){
    for(int i = 0; i < cars.size();i++){
      for(int j = 0; j < getCar(i).getSpeed();j++){
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
        if((getCar(i).getX() == getNext(i).getX()) && (getCar(i).getY() == getNext(i).getY()))
          getCar(i).hitLocation();
      }
    }
  }
  
  
  //checks for winner if the car location is greater than 4
  public boolean checkWinner(){
    for(int i =0; i<cars.size(); i++){
      if(getCar(i).getLocationsTouched() > lap)
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

  public void startAgain(){
    for(int i = 0; i < lap;i++){
      cars.get(i).draw().setVisible(false);
      cars.get(i).resetLocations();
    }
    cars.clear();
    for(int i = 0; i < lap; i++){
      cars.add(new Car(0,0, Color.RED,"Generic Race car","Generic Model","Car" + i));
      System.out.println(getCar(i));
      cars.get(i).setX(getNext(i).getX());
      cars.get(i).setY(getNext(i).getY());
    }
    
  }
  
  public int getCarTotal(){
    return cars.size();
  }
  
  private Location getNext(int index){
    return getLocation((index+getCar(index).getLocationsTouched())%lap);
  }
  
}

