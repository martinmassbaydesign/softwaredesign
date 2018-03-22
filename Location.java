/*
 * This is the Location class
 * The main purpose of this class is to create locations in the game
 * A Location will have a X and Y value with a Circle shape point.
 * Each Circle point will refer as a landmark where a Car is going to touch throughout the race
 * 
 * This class was written by Alex, Opie and Martin
 */
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
public class Location{
  
  private int xValue;
  private int yValue;
  private String name;
  
  //no arg constructor
  public Location(){
    xValue = 0;
    yValue = 0;
    name = "Empty";
    
  }
  
  //parameterized constructor
  public Location(int x,int y,String n){
    xValue = x;
    yValue = y;
    name = n;
    
  }
  
  //*************Getters**************//
  public int getX(){
    return xValue;
  }
  
  public int getY(){
    return yValue;
  }
  
  public String getName(){
    return name;
  }
  
  //*************Setters*************//
  public void setName(String n){
    name = n;
  }
  
  public void setCoords(int x, int y){
    xValue = x;
    yValue = y;
  }
  
  //Draw purple circles to refer as a landmark 
  public Circle draw(){
    Circle c = new Circle(xValue,yValue,3);
    c.setFill(Color.PURPLE);
    return c;
  }
}