
package Controller;

import Modle.*;
import Modle.Search.*;
import java.net.*;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Controller implements Initializable {


    
    @FXML Double space;
    @FXML StackPane TilePane;
    private ArrayList<Tile> tilesList;
    private Tile tiles[];
    private Bord bord;
    private DepthFirst depthFirst;
    @FXML Tile tile0;
    @FXML Tile tile1;
    @FXML Tile tile2;
    @FXML Tile tile3;
    @FXML Tile tile4;
    @FXML Tile tile5;
    @FXML Tile tile6;
    @FXML Tile tile7;
    @FXML Tile damy;
    @FXML Label setState; 
    @FXML Label goNext; 
    static byte counter = 0;
    
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        counter++;
        if (counter == 2) {
            tilesList = new ArrayList(9);
            tiles = new Tile[9];
            tiles[Byte.parseByte(tile0.getText())-1] = tile0;
            tiles[Byte.parseByte(tile1.getText())-1] = tile1;
            tiles[Byte.parseByte(tile2.getText())-1] = tile2;
            tiles[Byte.parseByte(tile3.getText())-1] = tile3;
            tiles[Byte.parseByte(tile4.getText())-1] = tile4;
            tiles[Byte.parseByte(tile5.getText())-1] = tile5;
            tiles[Byte.parseByte(tile6.getText())-1] = tile6;
            tiles[Byte.parseByte(tile7.getText())-1] = tile7;
            tiles[8] = damy;
            //.
            tilesList.addAll(Arrays.asList(tiles));
            bord = new Bord(tilesList);
            TilesTree tree = new TilesTree();
            depthFirst = new DepthFirst(tree.get(), null);
            counter = 0;
        }
    }
    
    
   public void move(Event e) {
    final int index = tilesList.indexOf(e.getSource());
    final Tile target = tilesList.get(index);
    //.
    bord.play(damy, target);
    TilePane.setDisable(true);
    target.setOnFinish(event->{
        TilePane.setDisable(false);
    });
}
   
    public void initiate() throws URISyntaxException {
        InitiaterStage ini = new InitiaterStage();
        ini.showAndWait();
        String texts[] = ini.getTexts();
        if (ini.isOk()) {
            bord.setTiles(
                    texts, 
                    tile0,
                    tile1,
                    tile2,
                    tile3,
                    tile4,
                    tile5,
                    tile6,
                    tile7,
                    damy);
        }else
            System.out.println( "can not initait that" );
    }

    public void setState() {
        byte[] values = (byte[]) depthFirst.getState(counter).getValue();
        String[] texts = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            texts[i] = Byte.toString(values[i]);
            System.out.println( texts[i] );
        }
        bord.setTiles(texts,tile0,tile1,tile2,tile3,tile4,tile5,tile6,tile7,damy);
        bord.applayState((byte[])depthFirst.getState(counter).getValue());
        System.out.println(Arrays.toString((byte[])depthFirst.getState(counter).getValue()));
        setState.setDisable(false);
        counter++;
    }
    
    public void goNext(){
        if(counter < depthFirst.len()){
            System.out.println("*");
            bord.applayState((byte[])depthFirst.getState(counter++).getValue());
            System.out.println(Arrays.toString((byte[])depthFirst.getState(counter).getValue()));
        }else
            goNext.setDisable(true);
    }
        
    
   public void exit(){
       System.exit(0);
   }
   
   
    
}
