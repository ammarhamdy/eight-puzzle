
package Controller;

import Model.Search.BreadthFirst;
import Model.Search.DepthFirst;
import Model.InitiaterStage;
import Model.Board;
import Model.Tile;
import Model.Tree.Samples;
import java.net.*;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Controller implements Initializable {


    @FXML Double gap;
    @FXML StackPane tilePane;
    @FXML Tile tile0;
    @FXML Tile tile1;
    @FXML Tile tile2;
    @FXML Tile tile3;
    @FXML Tile tile4;
    @FXML Tile tile5;
    @FXML Tile tile6;
    @FXML Tile tile7;
    @FXML Tile damy;
    @FXML Label start; 
    @FXML Label goNext;
    @FXML Label goBack;
    @FXML BorderPane controlBar;
    private Tile tiles[];
    private Board board;
    private DepthFirst<byte[]> depthFirst;
    private BreadthFirst<byte[]> breadthFirst;
    private List<byte[]> states;
    private byte length;
    private boolean turn;
    static byte counter = 0;
    
    
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        counter++;
        if (counter == 2) {
            tiles = new Tile[9];
            tiles[0] = damy;
            tiles[tile0.getNumber()] = tile0;
            tiles[tile1.getNumber()] = tile1;
            tiles[tile2.getNumber()] = tile2;
            tiles[tile3.getNumber()] = tile3;
            tiles[tile4.getNumber()] = tile4;
            tiles[tile5.getNumber()] = tile5;
            tiles[tile6.getNumber()] = tile6;
            tiles[tile7.getNumber()] = tile7;
            //.
            board = new Board(gap, (byte)3);
            Samples sample = new Samples();
            byte[] goal = {1, 4, 2,3, 0, 5,6, 7, 8};
            depthFirst = new DepthFirst(sample.getBytesTree(), goal);
            depthFirst.search();
            breadthFirst = new BreadthFirst(sample.getBytesTree(), goal);
            breadthFirst.search();
            states = (List<byte[]>) depthFirst.getStateList();
            length = (byte) depthFirst.len();
            counter = 0;
        }
    }
    
    
   public void play(Event event) {
    final int index = ((Tile)(event.getSource())).getNumber() ;
    final Tile target = tiles[index];
    //.
    tilePane.setDisable(board.play(damy, target));
    target.setOnFinish(e->tilePane.setDisable(false));
}
   
    public void enter() throws URISyntaxException {
        InitiaterStage ini = new InitiaterStage();
        ini.showAndWait();
        String texts[] = ini.getTexts();
        if (ini.isOk())
            board.reOrder(texts, tiles);
        else
            System.out.println( "can not initait that" );
    }

    public void start() {
        board.reOrder((byte[]) depthFirst.getState(counter++), tiles);
        start.setDisable(true);
        goNext.setDisable(false);
        turn = true;
    }
    
    public void goNext(){
        if( !turn ){
            counter+=2;
            turn = true;
        }
        Tile target = board.getTargeted(states.get(counter++), tiles);
        controlBar.setDisable(board.play(tiles[0], target));
        target.setOnFinish(e->controlBar.setDisable(false));
        goNext.setDisable(counter == length);
        goBack.setDisable(false);
    }
    
    public void goBack(){
        if(turn ){
            counter-=2;
            turn = false;
        }
        Tile target = board.getTargeted(states.get(counter--), tiles);
        controlBar.setDisable(board.play(tiles[0], target));
        target.setOnFinish(e->controlBar.setDisable(false));
        goBack.setDisable(counter == -1);
        goNext.setDisable(false);
    }
    
    public void useSearch(Event e){
        ComboBox select = (ComboBox)e.getSource();
        if( "depth first".equals((String)select.getValue())){
            states = depthFirst.getStateList();
            length = (byte)depthFirst.len();
        }else{
            states = breadthFirst.getStateList();
            length = (byte)breadthFirst.len();
        }
        start.setDisable(false);
        goNext.setDisable(true);
        goBack.setDisable(true);
        counter = 0;
    }
    
    public void autoPlay(Event event){
        board.reOrder(states.get(0), tiles);
//        for (int i = 0; i < states.size()-1; i++) {
//            tiles[i].setOnFinish(e->controlBar.setDisable(board.play(tiles[0], board.getTargeted(states.get(++counter), tiles))));
//        }
 Tile target =  board.getTargeted(states.get(++counter), tiles);
target.setOnFinish(e->board.play(tiles[0], board.getTargeted(states.get(++counter), tiles)));
        //board.play(tiles[0], board.getTargeted(states.get(1), tiles) );
    }
    
    public void exit(){
       System.exit(0);
   }
   
   
   
    
}
