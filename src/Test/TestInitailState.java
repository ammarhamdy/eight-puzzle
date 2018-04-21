
package Test;

import Modle.InitiaterStage;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class TestInitailState extends Application{

    byte counter = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        
//        ArrayList<Button> list = new ArrayList();
//        Button buttons[] = new Button[3];
//        for (int i = 0; i < buttons.length; i++) {
//            buttons[i] = new Button(""+i);
//        }
//        list.add(buttons[0]);
//        list.add(buttons[1]);
//        list.add(buttons[2]);
//
//        list.set(0, buttons[0]);
//        list.set(2, buttons[2]);
//        list.set(1, buttons[1]);
//        System.out.println( list );
        InitiaterStage iSatge = new InitiaterStage(); 
        iSatge.show();
        

    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
            
            /*        ObservableList<String> items = FXCollections.observableArrayList("1","2","3","4","5","6","7");
        ComboBox comboBox = new ComboBox(items);
        //.
        Button button = new Button("remove");
        HBox hbox = new HBox(comboBox,button);
        //.
        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.show();
        button.setOnAction(e->{
            items.remove( items.get(counter++ ) );
        });*/
}
