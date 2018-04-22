
package Modle.Search;


public class TilesTree {
    
    private SubTree<byte[]> tree;

    public TilesTree() {
        byte[] A = {0,1,2,3,4,5,6,7,8};
        byte[] B = {3,1,2,0,4,5,6,7,8};
            byte[] D = {3,1,2,6,4,5,0,7,8};
            byte[] E = {3,1,2,4,0,5,6,7,8};
        byte[] C = {1,0,2,3,4,5,6,7,8};
            byte[] F = {1, 4, 2,3, 0, 5,6, 7, 8};
            byte[] G = {1,2,0,3,4,5,6,7,8};
        
        
        //.
        
        Node<byte[]> d = new Node<>(D);
        Node<byte[]> e = new Node<>(E);
        Node<byte[]> f = new Node<>(F);
        Node<byte[]> g = new Node<>(G);     
        
        
        SubTree<byte[]> c = new SubTree<>(C , f,g );
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
