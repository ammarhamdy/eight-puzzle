
package Test;

import Modle.Search.Node;
import java.util.Arrays;


public class TestNode {
    
    public static void main(String[] args) {
        
        byte b[] = {1,1,2,4};
        Node<byte[]> node = new Node( new byte[]{1,2,3,7} );
        node.setValue(b);
        System.out.println(Arrays.toString(node.getValue()) );
        
    }
    
    
}
