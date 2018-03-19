import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class Test extends Application{
  
  public void start(Stage start){
    
    Stage a = new Stage();
        Group g = new Group(new Text("Test"));
    Scene b = new Scene(g);

    a.setScene(b);
    a.show();
  }
  
  public static void main(String args[]){
    launch(args);
  }
}