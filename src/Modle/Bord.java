
package Modle;

import java.util.ArrayList;

public class Bord {
    
    private final Tile tiles[][]; 
    static final double SPACE = 90; 
    static final byte SIZE = 3; 
    
    public Bord(ArrayList<Tile> tilesList){
        tiles = new Tile[3][3];
        setTilesOrder(tilesList);
    }
    
    
    public void setTiles(String texts[], Tile... tiles){
        for (int i = 0; i < tiles.length; i++) {
            tiles[i].setText(texts[i]);
            tiles[i].setTranslateX(SPACE* (i%3));
            tiles[i].setTranslateY(SPACE* (i/3));    
        }        
    }
    
    public void setTiles(byte texts[], Tile... tiles){
        for (int i = 0; i < tiles.length; i++) {
            tiles[i].setText(Byte.toString(texts[i]));
            tiles[i].setTranslateX(SPACE* (i%3));
            tiles[i].setTranslateY(SPACE* (i/3));    
        }        
    }
    
    
    public void applyState(byte[] state) {
        int lastXPos,lastYPos;
        int newXPos,newYPos;
        int i, j;
        //..
        i = 0;
        j = 0;
        for (; i < state.length; j++, i++) 
            if(state[i] == 0) break;
        newYPos = (i / SIZE);
        newXPos = (j % SIZE);
        Tile target = tiles[newYPos][newXPos];
        //System.out.println( "target: "+i/3+"  "+j%3 );
        //System.out.println("traget: \n"+"X: "+target.getTranslateX()+"\tY :"+target.getTranslateY()+"\ttext: "+target.getText());
        //..
        i = 0;
        j = 0;
        for (; i < (tiles.length*tiles[0].length); j++, i++) 
            if(Byte.parseByte( tiles[i/tiles.length][j%tiles[0].length].getText() ) == 0 ) break;
        lastYPos = (i / SIZE);
        lastXPos = (j % SIZE);
        Tile damy = tiles[lastYPos][lastXPos];
        //System.out.println( "damy: "+i/3+"  "+j%3 );
        //System.out.println("damy: \n"+"X: "+damy.getTranslateX()+"\tY :"+damy.getTranslateY()+"\ttext: "+damy.getText());
        //.
        move(damy, target);
    }
    
    
    public boolean move(Tile damy, Tile target) {
        final double damyTX = damy.getTranslateX();
        final double damyTY = damy.getTranslateY();
        final double targetTX = target.getTranslateX();
        final double targetTY = target.getTranslateY();
        //.
        if (targetTX == damyTX && Math.abs(damyTY - targetTY) == SPACE) {
            damy.setTranslateY(targetTY);
            target.setTranslateY(damyTY);
            
            return true;
        } else 
        if (targetTY == damyTY && Math.abs(damyTX - targetTX) == SPACE) {
            damy.setTranslateX(targetTX);
            target.setTranslateX(damyTX);
            return true;
        }else{
            target.rotate();
            return false;
        }
    }
    public boolean play(Tile damy, Tile target){
        final double damyTX = damy.getTranslateX();
        final double damyTY = damy.getTranslateY();
        final double targetTX = target.getTranslateX();
        final double targetTY = target.getTranslateY();
        //.
        if (targetTX == damyTX && Math.abs(damyTY - targetTY) == SPACE
                || targetTY == damyTY && Math.abs(damyTX - targetTX) == SPACE) {
            target.play(damyTX, damyTY);
            damy.play(targetTX, targetTY);
            return true;
        }else{
            target.rotate(); 
            return false;
        }
    }
    
    
    public void saveState(ArrayList<Tile> tilesList){
        for (byte i = 0; i < tilesList.size(); i++) {
            final byte x = getPosition(tilesList.get(i))[0];
            final byte y = getPosition(tilesList.get(i))[1];
            tiles[y][x] = tilesList.get(i);
        }        
    }
   
    
    ///...priavte...\\\
    private void setTilesOrder(ArrayList<Tile> tilesList){
        for (byte i = 0; i < tilesList.size(); i++) {
            final byte x = getPosition(tilesList.get(i))[0];
            final byte y = getPosition(tilesList.get(i))[1];
            tiles[y][x] = tilesList.get(i);
        }
    }
    
    private byte[] getPosition( Tile tile ){
        final byte position[] = new byte[2];
        position[0] = (byte)(tile.getTranslateX()/SPACE);
        position[1] = (byte)(tile.getTranslateY()/SPACE);
        return  position;
    } 
    



    
}