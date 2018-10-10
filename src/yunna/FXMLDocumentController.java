////////////////////////////////////////////////////////////////////////////////
// FXMLDocumentController.java
// ============
// a general purpose class to control FXML file
//
// AUTHOR: Yunna Won
// CREATED: 2018-03-23
// UPDATED: 2018-03-30
////////////////////////////////////////////////////////////////////////////////

package yunna;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.concurrent.Worker.State;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;

public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField textUrl;
    @FXML
    private Button backBotton;
    @FXML
    private Button forwardButton;
    @FXML
    private ProgressBar progress;
    @FXML
    private WebView webView;
    
    @Override
   public void initialize(URL url, ResourceBundle rb) {
       
       // set the degree of opacity to show background image
       this.webView.setOpacity(0.8D);
       
       // initialize search for showing progress bar
        Worker search = this.webView.getEngine().getLoadWorker();
      
        // add a chnageListener whenever the value of the ObservableValue changes
        search.stateProperty().addListener(new ChangeListener<State>()
        {
            @Override
            // initialize the observablevalue for changing
            public void changed(ObservableValue o, State pre, State neww)
            {
                if (neww == State.SCHEDULED)
                {
                    FXMLDocumentController.this.progress.setVisible(true);
                }

                if (neww == State.SUCCEEDED) {
                    FXMLDocumentController.this.progress.setVisible(false);
                } else if (neww == State.FAILED) {
                    FXMLDocumentController.this.progress.setVisible(false);
                }

            }
        });
    }

    
    @FXML
    private void handleGo(ActionEvent event)
    {
        // initialize str for search engine
        String str = this.textUrl.getText();
        this.webView.getEngine().load(str);
        
       // set start with http or https or with not empty
       if(!str.isEmpty())
       {
           if(!str.startsWith("http://") && !str.startsWith("https://"))
           {
               str = "http://" + str;
           }
           
           this.webView.getEngine().load(str);
           
       }
    } 


}
