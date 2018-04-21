
package eight.puzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.stage.StageStyle;


public class EightPuzzle extends Application{


    private double initialStageX;
    private double initialStageY;
    private double initialEventX;
    private double initialEventY;
    private boolean once = true;
    
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = FXMLLoader.load(getClass().getResource("/View/View.fxml"));
        BorderPane root = (BorderPane) scene.getRoot();
        BorderPane titlePane = (BorderPane)root.getTop();
        //.
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        //.
        titlePane.setOnMousePressed(event -> {
            if (once) {
                initialStageX = stage.getX();
                initialStageY = stage.getY();
                initialEventX = event.getScreenX();
                initialEventY = event.getScreenY();
                once = false;
            }
        });
        titlePane.setOnMouseDragged(event -> {
            stage.setX(((initialStageX * event.getScreenX()) / initialEventX));
            stage.setY(((initialStageY * event.getScreenY()) / initialEventY));
        });
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
