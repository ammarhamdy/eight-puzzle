
package Modle.Search;

import java.util.*;
import Modle.Tree.Tree;

public class DepthFirst<T>{
    
    private final ArrayList<T> states;
    private Tree<T> tree;
    private T goal;
    
    
    public DepthFirst(Tree<T> tree, T goal){
        this.states = new ArrayList<>();
        this.tree = tree;
        this.goal = goal;
    }
    
    public boolean search(){
        this.states.add(tree.getValue());
        if(isAGoal( tree.getValue() ))
            return true;
        return addStates(tree);
    }
    
    public T getState(int index){
        return states.get( index );
    }
    public ArrayList<T> getStateList() {
        return states;
    }
    public int len(){
        return states.size();
    }

    public T getGoal() {
        return goal;
    }
    public void setGoal(T goal) {
        this.goal = goal;
    }

    public Tree<T> getTree() {
        return tree;
    }
    public void setTree(Tree<T> tree) {
        this.tree = tree;
    }

    
    
    
    ///...priavte...\\\   
    private boolean addStates(Tree<T> tree){
        for (int i = 0; i < tree.getChildren().size(); i++) {
            if(tree.getChildren().get(i).isParent() ){
                states.add((T) tree.getChildren().get(i).getValue());
                if (isAGoal((T) tree.getChildren().get(i).getValue()) )
                    return true;
                if (addStates(tree.getChildren().get(i))) 
                    return true;
            }else{
                states.add((T) tree.getChildren().get(i).getValue());
                if (isAGoal((T) tree.getChildren().get(i).getValue()) )
                    return true;
                states.add(tree.getValue());
                continue;
            }
            states.add(tree.getValue());
        }
        return false;
    }
    
    private boolean isAGoal(T value){
//        System.out.println( value.getClass().getTypeName() );
//        System.out.println( value.getClass().getComponentType() );
//        Object o = value.getClass().getComponentType();
        if(value.getClass().isArray())
            return Arrays.equals( (byte[])value , (byte[])(goal) );
        return  value.equals(goal);
    }
    
    
    
    
    
}
