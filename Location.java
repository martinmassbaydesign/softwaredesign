import javafx.scene.shape.Circle;

public class Location{
  
  private int xValue;
  private int yValue;
  private String name;
  
  public Location(){
    xValue = 0;
    yValue = 0;
    name = "Empty";
    
  }
  
  public Location(int x,int y,String n){
    
    xValue = x;
    yValue = y;
    name = n;
    
  }
  
  public int getX(){
    return xValue;
  }
  
  public int getY(){
    return yValue;
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String n){
    name = n;
  }
  
  public void setCoords(int x, int y){
    xValue = x;
    yValue = y;
  }
  public Circle draw(){
    return new Circle(xValue,yValue,3);
  }
}