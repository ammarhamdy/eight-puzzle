
package Modle.Search;


public class TilesTree {
    
    private SubTree<byte[]> tree;

    public TilesTree() {
        byte[] A = {0,1,2,3,4,5,6,7,8};
        byte[] B = {3,1,2,0,4,5,6,7,8};
            byte[] D = {3,1,2,6,4,5,0,7,8};
            byte[] E = {3,1,2,4,0,5,6,7,8};
        byte[] C = {1,0,2,3,4,5,6,7,8};
        //.
        Node<byte[]> c = new Node<>(C);
        Node<byte[]> d = new Node<>(D);
        Node<byte[]> e = new Node<>(E);
        
        SubTree<byte[]> b = new SubTree<>(B, d,e);
        
        tree = new SubTree<>(A , b , c);
    }

    public SubTree get() {
        return tree;
    }

    public void set(SubTree tree) {
        this.tree = tree;
    }
    
    
    
    
}
