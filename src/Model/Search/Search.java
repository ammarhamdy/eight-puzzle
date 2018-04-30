
package Model.Search;

import Model.Tree.Tree;
import java.util.ArrayList;
import java.util.Arrays;


abstract class Search<T> {
    
    
    protected final ArrayList<T> states;
    protected Tree<T> tree;
    protected T goal;

    public Search( Tree tree, T goal  ) {
        this.states = new ArrayList<>();
        this.tree = tree;
        this.goal = goal;
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

    
    public boolean isGoal(T value){
        if(value.getClass().isArray())
            return Arrays.equals( (byte[])value , (byte[])(goal) );
        return  value.equals(goal);
    }  
    
    
    abstract boolean search();

    
}
