/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Modle.Search.DepthFirst;
import Modle.Search.SimpleTree;

public class TestDepth {
    
    
    public static void main(String[] args) {
        
        DepthFirst df = new DepthFirst(new SimpleTree().get(), null );
        for (int i = 0; i < df.len(); i++) {
            System.out.println( df.getState(i).getValue() );
        }
        
    }
    
}
