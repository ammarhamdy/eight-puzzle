/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Modle.Search.TilesTree;


public class TestBord {
    
    public static void main(String[] args) {
        byte state1[] = 
        {
            3, 1, 2,
            6, 4, 5,
            0, 7, 8
        };
        
        int i = 0;
        int j = 0;
        for (; i < state1.length; j++, i++) 
            if(state1[i] == 0) break;
        System.out.println( i/3 + "  " +j%3 );
        
        i = 0;
        j = 0;        
        byte state2[] = 
        {
            3, 1, 2,
            0, 4, 5,
            6, 7, 8
        };
        for (; i < state2.length; j++, i++) 
            if(state2[i] == 0) break;
        System.out.println( i/3 + "  " +j%3 );        
        
    }
    
    
    
    
}
