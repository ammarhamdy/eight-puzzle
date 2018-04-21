
package Test;

import Modle.Search.DepthFirst;
import Modle.Search.TilesTree;
import java.util.Arrays;

public class TestTilesTree {
    
    public static void main(String[] args) {
        
        TilesTree tt = new TilesTree();
        
        DepthFirst df = new DepthFirst(tt.get(), null);
        for (int i = 0; i < df.len(); i++) {
            System.out.println( Arrays.toString( (byte[])df.getState(i).getValue() ) );
        }
        
        
    }
    
    
}
