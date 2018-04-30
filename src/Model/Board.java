
package Model;

public class Board {
    
    private final double gap; 
    private final byte size;
    
    public Board(double gap, byte size){
        this.gap = gap;
        this.size = size;
    }

    /**
     * reorder tiles in board depend on number of each . 
     * @param numbers
     * @param tiles
     */
    public void reOrder(String numbers[], Tile[] tiles){
        for (int i = 0; i < tiles.length; i++){
            tiles[Byte.parseByte(numbers[i])].play(gap* (i%size),gap* (i/size));
            tiles[Byte.parseByte(numbers[i])].setTranslateX(gap* (i%size));
            tiles[Byte.parseByte(numbers[i])].setTranslateY(gap* (i/size));            
        }
    }
    public void reOrder(byte numbers[], Tile[] tiles){
        for (int i = 0; i < tiles.length; i++){
            tiles[numbers[i]].play(gap* (i%size),gap* (i/size));
            tiles[numbers[i]].setTranslateX(gap* (i%size));
            tiles[numbers[i]].setTranslateY(gap* (i/size));            
        }
    }


    /**
     * found  the index of tile[0];
     * look witch tile in same index in next state this tile will be target.
     * @param nextState
     * @param tiles
     */
    public void applyState(byte[] nextState,Tile[] tiles) {
        play(tiles[0], getTargeted(nextState, tiles));
    }
    
    /**
     * @param nextState
     * @param tiles
     * @return 
    */
    public Tile getTargeted(byte[] nextState,Tile[] tiles){
        return tiles[nextState[(byte) (rowOf(tiles[0])*size +  columnOf(tiles[0]))]];
    }
    
    
    /**
     * make two tiles to replace x&y together.
     * @param damy
     * @param target
     * @return 
     */
    public boolean swap(Tile damy, Tile target) {
        final double damyTX = damy.getTranslateX();
        final double damyTY = damy.getTranslateY();
        final double targetTX = target.getTranslateX();
        final double targetTY = target.getTranslateY();
        //.
        if (targetTX == damyTX && Math.abs(damyTY - targetTY) == gap) {
            damy.setTranslateY(targetTY);
            target.setTranslateY(damyTY);
            return true;
        } else 
        if (targetTY == damyTY && Math.abs(damyTX - targetTX) == gap) {
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
        if (targetTX == damyTX && Math.abs(damyTY - targetTY) == gap
                || targetTY == damyTY && Math.abs(damyTX - targetTX) == gap) {
            target.play(damyTX, damyTY);
            target.setTranslateX(damyTX);
            target.setTranslateY(damyTY);
            damy.play(targetTX, targetTY);
            damy.setTranslateX(targetTX);
            damy.setTranslateY(targetTY);
            return true;
        }else{
            target.rotate(); 
            return false;
        }
    }
    

    ///...priavte...\\\    
    private byte columnOf( Tile tile ){
        return (byte)(tile.getTranslateX()/gap);
    }
    private byte rowOf( Tile tile ){
        return (byte)(tile.getTranslateY()/gap);
    }



    
}