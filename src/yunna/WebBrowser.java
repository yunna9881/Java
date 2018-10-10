////////////////////////////////////////////////////////////////////////////////
// WebBrowser.java
// ============
// a general purpose class to launch program
//
// AUTHOR: Yunna Won
// CREATED: 2018-03-23
// UPDATED: 2018-03-30
////////////////////////////////////////////////////////////////////////////////

package yunna;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class WebBrowser extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        // set title of site
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        // Yunna + unicon = Yunicon
        stage.setTitle("Yunicon");  
        stage.setScene(scene);
        
        // set image of title
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("unicon.jpg")));

        // call css file
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        // Load Page
        stage.show();
     
    }
   
    
    public static void main(String[] args)
    {
        // launch program
        launch(args);    
    }
   
}
