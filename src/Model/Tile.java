
package Model;

import javafx.animation.*;
import javafx.beans.property.*;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.util.*;

public class Tile extends Button{
    
    private final SimpleIntegerProperty number;
    public static final byte NUMBER_OF_TILES = 8;
    //.
    private final TranslateTransition translateTransition;
    private Duration translateDuration;
    private final RotateTransition rotateTransition;
    private Duration RotateDuration;
    //.
    private static byte numberOfTiles = NUMBER_OF_TILES;
    private static final StringBuffer NUMBERS = new StringBuffer("");
    private static SimpleBooleanProperty isLastTile = new SimpleBooleanProperty(false);
    static {setNumbers();}

    
    public Tile(byte number){
        this.number = new SimpleIntegerProperty();
        this.number.set(number);
        setText(Byte.toString(number));
        translateDuration = new Duration(500);
        translateTransition = new TranslateTransition(translateDuration, this);
        RotateDuration = new Duration(200);
        rotateTransition = new RotateTransition(RotateDuration, this);
        setRotateTransition();
    }
    
    public Tile(){
        this.number = new SimpleIntegerProperty();
        if(!isLastTile.get())
            this.number.set(getAnyNumber());
        setText(Byte.toString((byte)number.get()));
        translateDuration = new Duration(500); 
        translateTransition = new TranslateTransition(translateDuration, this);
        RotateDuration = new Duration(200);
        rotateTransition = new RotateTransition(RotateDuration, this);
        setRotateTransition();
    }
    
    
    public void setNumber(byte number){
        this.number.set(number);
    }
    public byte getNumber(){
        return (byte)number.get();
    }
    
    public IntegerProperty getNumberProperty(){
        return number;
    }
    
    public void setIsLastTile(boolean isDamy){
        Tile.isLastTile.set(isDamy);
    }
    public boolean getIsLastTile(){
        return isLastTile.get();
    }
    public BooleanProperty getIsLastTileProperty(){
        return isLastTile;
    }
    
    public void setMoveDuration(Duration duration){
        this.translateDuration = duration;
        translateTransition.setDuration(duration);
    }
    public void setRotateDuration(Duration duration){
        this.RotateDuration = duration;
    }
    
//    public void moveHorizentallyTo(double value){
//        translateTransition.setToX(value);
//        translateTransition.play();
//    }
//    public void moveVerticallyTo(double value){
//        translateTransition.setToY(value);
//        translateTransition.play();
//    }
    
    public void play(double tx , double ty){
        translateTransition.setToX(tx);
        translateTransition.setToY(ty);
        translateTransition.play();
    }
    
    public void rotate(){
        rotateTransition.play();
    }
    
    public void stopMoveing(){
        translateTransition.stop();
    }
    
    
    public void setOnFinish(EventHandler  e){
        translateTransition.setOnFinished(e);
    }
    
    ///...private...\\\
    private static void setNumbers(){ 
        for (byte i = 1; i < NUMBER_OF_TILES+1; i++)
            NUMBERS.append(i);
    }
    
    private byte getAnyNumber(){
        final byte index = (byte)(Math.random()*(numberOfTiles) );
        final byte targetNumber = Byte.parseByte(Character.toString(NUMBERS.charAt(index)) );
        NUMBERS.deleteCharAt(index);
        numberOfTiles--;
        return targetNumber;
    }
    
    private void setRotateTransition(){
        rotateTransition.setCycleCount(2);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setToAngle(45);
    }
    
}
