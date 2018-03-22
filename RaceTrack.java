/**
 * RaceTrack.java
 * This is a controller class that centralizes cars and the locations they're going to. It provides
 * access for the RaceVenue and GUI to control each feature.
 * Most of the code in here is made by Martin - non-martin code will be specified.
 */

import java.util.ArrayList;
import java.util.Timer;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class RaceTrack {
  
  private ArrayList<Car> cars;
  private ArrayList<Location> locations;
  
  private int lap; // Keeps track of the number of locations needed to hit to win. (Currently locked at 4)
  
  // Default Constructor
  public RaceTrack(){
    this.lap = 4;
    cars = new ArrayList<Car>();
    locations = new ArrayList<Location>();
    for(int i = 0; i < lap;i++){ // Sets up the cars and locations at current locations - would have to update for future expansion.
      locations.add(new Location());
      cars.add(new Car(0, 0, randomColor(),"Generic Race car","Generic Model","Car " + i));
      if(i%2 == 0)
          getLocation(i).setCoords(25+(275*i),200);
       if(i%2 == 1)
          getLocation(i).setCoords(300,200*(i-1));
      
        getCar(i).setX(getLocation(i).getX());
        getCar(i).setY(getLocation(i).getY());
    }
  }
  
  // Gets the winner of the race, by checking if they've touched the required number of locations.
  // Done in-class with Alex, Opie, and Martin.
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
  
  // Moves every car towards the next location they're aiming to touch.
  // Loops equal to their speed.
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
      }}}
  
  //checks for winner if the car location is greater than 4
  // Code by Alex, Martin and Ope - In class.
  public boolean checkWinner(){
    for(int i =0; i<cars.size(); i++){
      if(getCar(i).getLocationsTouched() > lap)
        return true;
    }
    return false;
  }
  
  // Draws the cars and Location points.
  // Code by Alex Martin and Opie - in class.
  public Group drawTrack(){
    Group g = new Group();
    for(Car c : cars){ g.getChildren().add(c.draw());}
    for(Location l : locations){ g.getChildren().add(l.draw());}
    return g;
  }
  
  // returns a specific Car
  // Alex Martin Opie
  public Car getCar(int carNum){
    return cars.get(carNum);
  }
  
  // returns a specific Location.
  // Alex Martin Opie
  public Location getLocation(int locationNum){
    return locations.get(locationNum);
    
  }

  // Resets the cars setting their location count to 0 and re-initializing them.
  public void startAgain(){
    for(int i = 0; i < lap;i++){
      cars.get(i).draw().setVisible(false);
      cars.get(i).resetLocations();
    }
    cars.clear();
    for(int i = 0; i < lap; i++){
      cars.add(new Car(0,0, randomColor(),"Generic Race car","Generic Model","Car " + i));
      System.out.println(getCar(i));
      cars.get(i).setX(getNext(i).getX());
      cars.get(i).setY(getNext(i).getY());
    }
  }
  
  
  // returns the number of cars in the track.
  public int getCarTotal(){
    return cars.size();
  }
  
  // Helper method to get the next location relevant to a car.
  private Location getNext(int index){
    return getLocation((index+getCar(index).getLocationsTouched())%lap);
  }
  
  // Provides a random color from a list to assign to cars.
  private Color randomColor(){
    Color[] colors = new Color[] {Color.RED,Color.BLUE,Color.YELLOW,Color.MAGENTA,Color.BEIGE,Color.MISTYROSE,Color.ORANGE,Color.NAVAJOWHITE,Color.LINEN,Color.MINTCREAM,Color.SEASHELL,Color.SIENNA,Color.PEACHPUFF,Color.ORCHID};
    return colors[(int)(Math.random()*14)];
  }
  
}

