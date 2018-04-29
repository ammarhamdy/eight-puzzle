
package Modle.Tree;

import java.util.ArrayList;
import java.util.Arrays;


public class Tree<T>{
    
    private final ArrayList<Tree> children;
    private T value;
    
    public Tree(){
        children = new ArrayList<>();
    }
    public Tree(T value){
        this.value = value;
        children = new ArrayList();
    }
    public Tree(Tree... tree){
        this.children = new ArrayList<>();
        children.addAll(Arrays.asList(tree));
    }
    public Tree(T value, Tree... tree){
        this.value = value;
        children = new ArrayList();
        children.addAll(Arrays.asList(tree));
    }
    
    
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public void printValueType(){
        System.out.println( value.getClass().getName() );
    }
    
    
    public ArrayList<Tree> getChildren(){
        return children;
    }

    
    public boolean isLeaf(){
        return children.size() < 1;
    }
    public boolean isParent(){
        return children.size() > 0;
    }
    
        
    
    
}
