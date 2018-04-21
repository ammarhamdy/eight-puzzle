
package Modle.Search;


public class SimpleTree {
    
    private SubTree tree;

    public SimpleTree() {
        setTree();
    }
    
    
    
    public SubTree get() {
        return tree;
    }

    public void set(SubTree tree) {
        this.tree = tree;
    }
    
    
    ///...private...\\\
    private void setTree(){
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
        set(a);
    }
        
    
}
