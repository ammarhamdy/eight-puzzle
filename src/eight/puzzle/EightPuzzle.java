
package eight.puzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*; 
import javafx.stage.StageStyle;

/**
 *
 * @author ammar elshaar
 */
public class EightPuzzle extends Application{


//    private double initialStageX;
//    private double initialStageY;
//    private double initialEventX;
//    private double initialEventY;
//    private boolean once = true;
    //.
    private double mousePressedX;
    private double mousePressedY;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(" you can get last update to this code from  "
                + "'https://github.com/ammarhamdy/eight-puzzle'");
        Scene scene = FXMLLoader.load(getClass().getResource("/View/View.fxml"));
        BorderPane root = (BorderPane) scene.getRoot();
        BorderPane titlePane = (BorderPane)root.getTop();
        //.
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        //.
//        titlePane.setOnMousePressed(event -> {
//            if (once) { 
//                initialStageX = stage.getX();
//                initialStageY = stage.getY();
//                initialEventX = event.getScreenX();
//                initialEventY = event.getScreenY();
//                once = false;
//            }
//        });
//        titlePane.setOnMouseDragged(event -> {
//            stage.setX(((initialStageX * event.getScreenX()) / initialEventX));
//            stage.setY(((initialStageY * event.getScreenY()) / initialEventY));
//        });
        titlePane.setOnMousePressed(event -> {
            mousePressedX = event.getScreenX();
            mousePressedY = event.getScreenY();
        });
        titlePane.setOnMouseDragged(event -> {
             stage.setX(stage.getX() + (event.getScreenX()-mousePressedX));
            mousePressedX = event.getScreenX();
            stage.setY(stage.getY() + (event.getScreenY()-mousePressedY));
            mousePressedY = event.getScreenY();
        });

    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
