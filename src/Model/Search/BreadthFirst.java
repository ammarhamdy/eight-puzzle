
package Model.Search;

import Model.Tree.Tree;
import java.util.*;

public class BreadthFirst<T> extends Search<T>{
    
    private final Queue<Tree> queue;

    
    
    public BreadthFirst(Tree tree, T goal){
        super(tree, goal);
        this.queue = new LinkedList();
    }

    
    @Override
    public boolean search(){
        return addStates(tree);
    }
    
    ///...priavte...\\\
    boolean first = true;
    private boolean addStates(Tree tree) {
        Tree temp =  tree;
        states.add((T) temp.getValue());
        if(isGoal((T) temp.getValue()))
            return true;
        int i ;
        while (!queue.isEmpty() || first) {
            first = false;
            if (temp.isParent()) {
                for (i = 0; i < temp.getChildren().size(); i++) 
                    queue.add((Tree) temp.getChildren().get(i) );
                temp = queue.remove();
                states.add((T) temp.getValue());
                if(isGoal((T) temp.getValue()))
                    return true;                
            }else {
                temp = queue.remove();
                states.add((T) temp.getValue());
                if(isGoal((T) temp.getValue()))
                    return true;                
            }
        }
        return false;
    }
    

    
}
