
package Model.Search;

import Model.Tree.Tree;

public class DepthFirst<T> extends Search<T>{
    
    
    
    public DepthFirst(Tree<T> tree, T goal){
        super(tree, goal);
    }
    
    @Override
    public boolean search(){
        this.states.add(tree.getValue());
        if(isGoal( tree.getValue() ))
            return true;
        return addStates(tree);
    }
    
    
    ///...priavte...\\\   
    private boolean addStates(Tree<T> tree){
        for (int i = 0; i < tree.getChildren().size(); i++) {
            if(tree.getChildren().get(i).isParent() ){
                states.add((T) tree.getChildren().get(i).getValue());
                if (isGoal((T) tree.getChildren().get(i).getValue()) )
                    return true;
                if (addStates(tree.getChildren().get(i))) 
                    return true;
            }else{
                states.add((T) tree.getChildren().get(i).getValue());
                if (isGoal((T) tree.getChildren().get(i).getValue()) )
                    return true;
                states.add(tree.getValue());
                continue;
            }
            states.add(tree.getValue());
        }
        return false;
    }
    
    
    
    
    
}
