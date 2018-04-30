
package Model;

import java.net.URISyntaxException;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;


public class InitiaterStage extends Stage implements EventHandler{

    private final Scene scene;
    private final BorderPane pane;
    private final GridPane gridPane;
    private final ButtonBar buttonBar;
    private final Button buttons[];
    private final Button tiles[];
    private final Button reinitiat;
    private byte count;
    private final String[] texts;
    private boolean ok; 
    
    public InitiaterStage() throws URISyntaxException{
        super(StageStyle.UTILITY);
        gridPane = new GridPane();
        buttonBar = new ButtonBar();
        reinitiat = new Button("o");
        pane = new BorderPane(gridPane, buttonBar, null, reinitiat, null);
        buttons = new Button[8];
        tiles = new Button[8];
        scene = new Scene(pane);
        texts = new String[9];
        ok = false;
        count = 0;
        setButtons();
        setTiles();
        setGridPane();        
        setScene(scene);
        setStyle();
    }
    
    
    public boolean isOk() {
        return ok;
    }
    public String[] getTexts(){
        return texts; 
    }
    
    ///...private ...\\\
    private void reinitiat(){
        if(count == 8){
            for (int i = 0; i < tiles.length; i++)
                texts[i] = tiles[i].getText();
            texts[texts.length-1] = "0";
            ok = true;
            close();
        }else{
            new Alert(Alert.AlertType.ERROR, "fill all tiles",ButtonType.CLOSE).show();
        }
    }
    

    private void setButtons(){
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(""+(i+1));
            buttons[i].setOnAction(this);
        }
        buttonBar.getButtons().addAll(buttons);
        reinitiat.setOnAction(this);
    }
    private void setTiles(){
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Button();
            tiles[i].setId("button");
        }
    }
    private void setGridPane(){
        for (int i = 0; i < tiles.length; i++) {
            gridPane.add(tiles[i], i%3, i/3);
        }
        gridPane.setHgap(7);
        gridPane.setVgap(7);
        gridPane.setAlignment(Pos.CENTER);
    }
    private void setStyle() throws URISyntaxException{
        pane.setId("pane");
        scene.getStylesheets().addAll("file:"+
                this.getClass().
                getProtectionDomain().
                getCodeSource().
                getLocation().
                getPath()
                +"View/Style/style.css");
    }
    
    
    //.
    @Override
    public void handle(Event event) {
        final Button target = (Button) event.getSource();
        if(target == reinitiat){
            reinitiat();
        }else{
            tiles[count++].setText(target.getText());
            target.setDisable(true);
        }
    }

    
}