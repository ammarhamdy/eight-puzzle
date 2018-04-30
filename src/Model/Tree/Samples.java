
package Model.Tree;



public class Samples {
    
    Tree<byte[]> tree;
    Tree<Character> charsTree;

    public Samples() {
        setTree();
        setCharsTree();
    }
    
    public Tree getBytesTree(){
        return tree;
    }
    public Tree getCharsTree(){
        return charsTree;
    }
    
    ///...private...\\\
    private void setTree(){
        byte[] A = {0,1,2,3,4,5,6,7,8};
        byte[] B = {3,1,2,0,4,5,6,7,8};
            byte[] D = {3,1,2,6,4,5,0,7,8};
            byte[] E = {3,1,2,4,0,5,6,7,8};
        byte[] C = {1,0,2,3,4,5,6,7,8};
            byte[] F = {1, 4, 2,3, 0, 5,6, 7, 8};
            byte[] G = {1,2,0,3,4,5,6,7,8};
         //.
        tree = new Tree(A);
        Tree<byte[]> b = new Tree(B);
        Tree<byte[]> c = new Tree(C);
        Tree<byte[]> d = new Tree(D);
        Tree<byte[]> e = new Tree(E);
        Tree<byte[]> f = new Tree(F);
        Tree<byte[]> g = new Tree(G);
        //.
        b.getChildren().add(d);
        b.getChildren().add(e);
        //.
        c.getChildren().add(f);
        c.getChildren().add(g);
        //.
        tree.getChildren().add(b);
        tree.getChildren().add(c);
    }
    private void setCharsTree(){
        charsTree = new Tree('A');
        Tree<Character> b = new Tree('B');
        Tree<Character> c = new Tree('C');
        Tree<Character> d = new Tree('D');
        Tree<Character> e = new Tree('E');
        Tree<Character> f = new Tree('F');
        Tree<Character> g = new Tree('G');
        //.
        b.getChildren().add(d);
        b.getChildren().add(e);
        //.
        c.getChildren().add(f);
        c.getChildren().add(g);
        //.
        charsTree.getChildren().add(b);
        charsTree.getChildren().add(c);        
    }
    
}
