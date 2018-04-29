
package Modle.Search;

import Modle.Tree.Tree;
import java.util.*;

public class BreadthFirst<T> {
    
    private final ArrayList<T> states;
    private final Queue<Tree> queue;
    private T goal;
    private Tree tree;
    
    
    public BreadthFirst(Tree tree, T goal){
        this.states = new ArrayList();
        this.queue = new LinkedList();
        this.tree = tree;
        this.goal = goal;
    }

    
    public boolean search(){
        return addStates(tree);
    }
    
    public T getState(int index){
        return states.get( index );
    }
    public ArrayList<T> getStateList(){
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

    public Tree getTree() {
        return tree;
    }
    public void setTree(Tree tree) {
        this.tree = tree;
    }

    
    
    ///...priavte...\\\
    boolean first = true;
    private boolean addStates(Tree tree) {
        Tree temp =  tree;
        states.add((T) temp.getValue());
        if(isAGoal((T) temp.getValue()))
            return true;
        int i ;
        while (!queue.isEmpty() || first) {
            first = false;
            if (temp.isParent()) {
                for (i = 0; i < temp.getChildren().size(); i++) 
                    queue.add((Tree) temp.getChildren().get(i) );
                temp = queue.remove();
                states.add((T) temp.getValue());
                if(isAGoal((T) temp.getValue()))
                    return true;                
            }else {
                temp = queue.remove();
                states.add((T) temp.getValue());
                if(isAGoal((T) temp.getValue()))
                    return true;                
            }
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
