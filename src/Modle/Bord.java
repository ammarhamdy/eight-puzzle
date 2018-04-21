
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
    
    
    public void applayState( String texts[][] ){
        int lastXPos,lastYPos;
        int newXPos,newYPos;
        int i, j;
        //......
        i = 0;
        j = 0;
        for (; i < (tiles.length*tiles[0].length);j++, i++) 
            if("0".equals(texts[i/tiles.length][j%tiles[0].length])) break;
        newXPos = (j % tiles[0].length);
        newYPos = (i / tiles.length);
        Tile target = tiles[newYPos][newXPos];
        //.....
        i = 0;
        j = 0;
        for (; i < (tiles.length*tiles[0].length);j++, i++) 
            if("0".equals(tiles[i/tiles.length][j%tiles[0].length].getText()))break;
        lastXPos = (j % tiles[0].length);
        lastYPos = (i / tiles.length);
        Tile damy = tiles[lastYPos][lastXPos];
        //....
        move(damy, target);
    }
    
    public void applayState(byte[] state) {
        int lastXPos,lastYPos;
        int newXPos,newYPos;
        int i, j;
        //..
        i = 0;
        j = 0;
        for (; i < state.length; j++, i++) 
            if(state[i] == 0) break;
        newXPos = (j % SIZE);
        newYPos = (i / SIZE);
        Tile target = tiles[newYPos][newXPos];
        //..
        i = 0;
        j = 0;
        for (; i < (tiles.length*tiles[0].length); j++, i++) 
            if(Byte.parseByte( tiles[i/tiles.length][j%tiles[0].length].getText() ) == 0 ) break;
        lastXPos = (j % SIZE);
        lastYPos = (i / SIZE);
        Tile damy = tiles[lastYPos][lastXPos];
        //.
        move(damy, target);
    }
    
    
    public void move(Tile damy, Tile target) {
        final double damyTX = damy.getTranslateX();
        final double damyTY = damy.getTranslateY();
        final double targetTX = target.getTranslateX();
        final double targetTY = target.getTranslateY();
        //.
        if (targetTX == damyTX && Math.abs(damyTY - targetTY) == SPACE) {
            damy.setTranslateY(targetTY);
            target.setTranslateY(damyTY);
        } else 
        if (targetTY == damyTY && Math.abs(damyTX - targetTX) == SPACE) {
                damy.setTranslateX(targetTX);
                target.setTranslateX(damyTX);
        }else
            target.rotate();
    }
    public void play(Tile damy, Tile target){
        final double damyTX = damy.getTranslateX();
        final double damyTY = damy.getTranslateY();
        final double targetTX = target.getTranslateX();
        final double targetTY = target.getTranslateY();
        //.
        if (targetTX == damyTX && Math.abs(damyTY - targetTY) == SPACE
                || targetTY == damyTY && Math.abs(damyTX - targetTX) == SPACE) {
            target.play(damyTX, damyTY);
            damy.play(targetTX, targetTY);
        }else
            target.rotate();        
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