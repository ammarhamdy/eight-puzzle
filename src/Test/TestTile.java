
package Test;

import Modle.Tile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TestTile extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Tile tiles[] = new Tile[Tile.NUMBER_OF_TILES];
        FlowPane flowPane;
        Scene scene;
        //.
        for (int i = 0; i < Tile.NUMBER_OF_TILES; i++) {
            tiles[i] = new Tile();
        }
        
        flowPane = new FlowPane(tiles);
        scene = new Scene(flowPane,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
