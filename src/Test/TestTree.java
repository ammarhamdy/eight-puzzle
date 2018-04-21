/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Modle.Search.Node;
import Modle.Search.*;


public class TestTree {
    
    public static void main(String[] args) {
        
        TestTree tt = new TestTree();
        
        Node u = new Node('U');
        Node h = new Node('H');
        //1
        SubTree a = new SubTree('A', u,h);
        
        Node d = new Node('D');
        Node e = new Node('E');
        //2
        SubTree b = new SubTree('B', d,e);

        Node o = new Node('O');
        Node n = new Node('N');
        //3
        SubTree i = new SubTree('I', o,n);
        
        Node f = new Node('F');
        Node g = new Node('G');
        //4
        SubTree c = new SubTree('C');
        c.getChildren().addAll(f,i);
        c.getChildren().add(g);
        
        a.getChildren().add(c);
        a.getChildren().add(b);
        
        
        
        
        Tree tree = new Tree('O');
        tree.getChildren().add(a);
        
        //.
        System.out.println( tree.getChildren().hasSubTree() );
        System.out.println( tree.getRoot().getValue() );
        printReport(a);
        
        //System.out.println( a.getCharValue() );
        SimpleTree simpleTree = new SimpleTree();
        tt.df(simpleTree.get());
        tt.df(a);
        
    }
    
    static void printReport( SubTree sub1 ){
        System.out.println("isSubTree? "+sub1.isSubtree());
        System.out.println("isNode? "+sub1.isNode());
        System.out.println("number of node: "+ sub1.getChildren().nodesSize());
        System.out.println("number of subTree: "+sub1.getChildren().subTreesSize());
        System.out.println("numebr of children: "+sub1.getChildren().size());
        System.out.println("value: "+sub1.getValue());
        for (int i = 0; i < sub1.getChildren().size(); i++) 
            System.out.println("child "+i+": "+sub1.getChildren().getChild(i).getValue());
        for (int i = 0; i < sub1.getChildren().nodesSize(); i++) 
            System.out.println("node "+i+": "+sub1.getChildren().getNode(i).getValue()); 
        for (int i = 0; i < sub1.getChildren().subTreesSize(); i++) 
            System.out.println("subTree "+i+": "+sub1.getChildren().getSubTree(i).getValue());
        System.out.println("\n");
    }
    
    
     void df(SubTree sub0){
         SubTree pointer = sub0;
        for (int i= 0; i< pointer.getChildren().size(); i++) {
            if(pointer.getChildren().getChild(i) instanceof SubTree){
                System.out.println( ((SubTree)pointer.getChildren().getChild(i)).getValue() );
                df((SubTree)pointer.getChildren().getChild(i));
            }else{
                System.out.println(pointer.getChildren().getChild(i).getValue());
                System.out.println( ((SubTree) pointer.get()).getValue());
                continue;
            }
            System.out.println( ((SubTree) pointer.get()).getValue());
        }
       System.out.println("finish");
    }
    
}


//            try{
//                pointer = (SubTree)pointer.getChildren().getChild(i);
//                /*is subTree*/
//                System.out.println( pointer.getCharValue() );
//                df(pointer);
//                System.out.println("*");
//            }catch(Exception ex){
//                /*is node*/
//                Node child = pointer.getChildren().getChild(i);
//                System.out.println(child.getCharValue());
//                pointer = (SubTree) pointer.getParentNode();
//                System.out.println(pointer.getCharValue());
//                continue;
//            }
//            System.out.println( ((SubTree)pointer.getParentNode()).getParentNode().getCharValue() );
//            Node child = pointer.getChildren().getChild(i);
//            System.out.println( child.getCharValue() );
