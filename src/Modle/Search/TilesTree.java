
package Modle.Search;


public class TilesTree {
    
    private SubTree<byte[]> tree;

    public TilesTree() {
        byte[] b1 = {0,1,2,3,4,5,6,7,8};
        byte[] b11 = {1,0,2,3,4,5,6,7,8};
            byte[] b111 = {1,2,0,3,4,5,6,7,8};
            byte[] b112 = {1,2,5,3,4,0,6,7,8};
        byte[] b12 = {3,1,2,0,4,5,6,7,8};
        //.
        Node<byte[]> c = new Node<>(b12);
        Node<byte[]> d = new Node<>(b111);
        Node<byte[]> e = new Node<>(b112);
        
        SubTree<byte[]> b = new SubTree<>(b11, d,e);
        
        tree = new SubTree<>(b1 , b , c);
    }

    public SubTree get() {
        return tree;
    }

    public void set(SubTree tree) {
        this.tree = tree;
    }
    
    
    
    
}
