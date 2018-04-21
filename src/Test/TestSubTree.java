
package Test;

import Modle.Search.*;


public class TestSubTree {
    
    public static void main(String[] args) {
        
        Node u = new Node('U');
        Node h = new Node('H');
        //1
        SubTree tree = new SubTree('A', u,h);

        
        printReport(tree);
        
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
        c.getChildren().addAll(f,g);
        c.getChildren().add(i);
        
        tree.getChildren().add(b);
        tree.getChildren().add(c);
        
        printReport(tree);
        //.
        
        
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
    
    
}
