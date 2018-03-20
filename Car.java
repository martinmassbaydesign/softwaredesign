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
    speed = 1+(int)(Math.random()*5);
    color = Color.RED;
    locationsTouched = 0;
    make = "Generic";
    model = "Generic";
    carShape = new Rectangle(xLocation,yLocation,50,20);
    carShape.setFill(color);
  }
  
  public Car(int x, int y, Color c,String mk,String mdl){
    xLocation = x;
    yLocation = y;
    color = c;
    make = mk;
    model = mdl;
    speed = 1+(int)(Math.random()*5);
    locationsTouched = 0;
    carShape = new Rectangle(xLocation,yLocation,50,20);
    carShape.setFill(color);
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
    update();
    carShape.setFill(color);
    return carShape;
  }
  
  public String toString(){
    return "X location: " + getX() +"\nYLocation: " + getY() + "\nMake: " + getMake() + "\nModel: " + getModel() + "\nSpeed: " + getSpeed() + "\nColor: " + getColor();
  }
  
   //********************* Setters ****************************************
  
  public void setX(int x){
    xLocation = x;
    update();
  }
  
  public void setY(int y){
    yLocation = y;
    update();
  }
  
  public void moveX(int x){
    xLocation+=x;
    update();
  }
  
  public void moveY(int y){
    yLocation+=y;
    update();
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
  
  public void resetLocations(){
    locationsTouched = 0;
  }
  
  // **************** Helper Methods ******************
  private void update(){
    carShape.setY(yLocation);
    carShape.setX(xLocation);
}
}