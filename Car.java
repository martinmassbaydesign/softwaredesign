import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class Car{
  
  private int xLocation;
  private int yLocation;
  private int speed;
  private Color color;
  private int locationsTouched;
  private String make;
  private String model;
  private String carName;
  private Rectangle carShape;
  private Text title;
  
  public Car(){
    carName = "Generic car";
    xLocation = 0;
    yLocation = 0;
    speed = 1+(int)(Math.random()*5);
    color = Color.RED;
    locationsTouched = 0;
    make = "Generic";
    model = "Generic";
    carShape = new Rectangle(xLocation,yLocation,50,20);
    carShape.setFill(color);
    title = new Text(xLocation,yLocation-10,carName);
  }
  
  public Car(int x, int y, Color c,String mk,String mdl,String name){
    xLocation = x;
    yLocation = y;
    carName = name;
    color = c;
    make = mk;
    model = mdl;
    speed = 1+(int)(Math.random()*5);
    locationsTouched = 0;
    carShape = new Rectangle(xLocation,yLocation,50,20);
    carShape.setFill(color);
    title = new Text(xLocation,yLocation-10,carName);
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
  
  public Group draw(){
    Group car = new Group();
    update();
    carShape.setFill(color);
    car.getChildren().add(title);
    car.getChildren().add(carShape);
    return car;
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
    title.setY(yLocation-10);
    title.setX(xLocation);
    carShape.setY(yLocation);
    carShape.setX(xLocation);
}
}