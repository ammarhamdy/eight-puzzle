
package Modle.Search;


public class SubTree<T> extends Node<T>{
    

    private final Children children;
    private T t ;
    
    public SubTree(){
        this.children = new Children();
    }
    public SubTree(Node... children){
        this.children = new Children();
        this.children.addAll(children);
    }
    public SubTree(SubTree subTree) {
        this.children = new Children();
        this.children.add(subTree);
    }
    public SubTree(SubTree subTree, Node... children){
        this.children = new Children();
        this.children.add(subTree);
        this.children.addAll(children);
    }
    
    public SubTree(T value){
        super(value);
        this.children = new Children();
    }
    public SubTree(T value, Node... children){
        super(value);
        this.children = new Children();
        this.children.addAll(children);
    }
    public SubTree(T value, SubTree subTree) {
        super(value);
        this.children = new Children();
        this.children.add(subTree);
    }
    public SubTree(T value, SubTree subTree, Node... children){
        super(value);
        this.children = new Children();
        this.children.add(subTree);
        this.children.addAll(children);
    }
    
    
    
    
    public Node get() {
        return this;
    }
    
    public Children getChildren(){
        return children;
    }

    public boolean isNode(){
        return children.nodesSize()< 1
                && children.subTreesSize()< 1;
    }

    public boolean isSubtree(){
        return children.nodesSize()> 0
                || children.subTreesSize()> 0; 
    }
    
    
    
    
}
