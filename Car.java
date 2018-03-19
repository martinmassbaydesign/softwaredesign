import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Car{
  
  private int xLocation;
  private int yLocation;
  private int speed;
  private Color color;
  private int locationsTouched;
  private String make;
  private String model;
  private Rectangle carShape;
  
  public Car(){
    xLocation = 0;
    yLocation = 0;
    speed = 1;
    color = Color.RED;
    locationsTouched = 0;
    make = "Generic";
    model = "Generic";
    carShape = new Rectangle(xLocation,yLocation,50,20);
  }
  
    //********************* Getters ****************************************
  
  public int getY(){
    return yLocation;
  }
  
  public int getX(){
    return xLocation;
  }
  
  public int getSpeed(){
    return speed;
  }
  
  public String getMake(){
    return make;
  }
  
  public String getModel(){
    return model;
  }
  
  public int getLocationsTouched(){
    return locationsTouched;
  }
  
  public Color getColor(){
    return color;
  }
  
  public Rectangle draw(){
    return carShape;
  }
  
  public String toString(){
    return "X location: " + getX() +"\nYLocation: " + getY() + "\nMake: " + getMake() + "\nModel: " + getModel() + "\nSpeed: " + getSpeed() + "\nColor: " + getColor();
  }
  
   //********************* Setters ****************************************
  
  public void setX(int x){
    xLocation = x;
  }
  
  public void setY(int y){
    yLocation = y;
  }
  
  public void moveX(int x){
    xLocation+=x;
  }
  
  public void moveY(int y){
    yLocation+=y;
  }
  
  public void setSpeed(int speedValue){
    speed = speedValue;
  }
  
  public void goTurbo(boolean yesno){
    if(yesno){
      speed = speed*2;
    }
    else
      speed = speed;
  }
  
  public void hitLocation(){
    locationsTouched++;
  }
  
}
  