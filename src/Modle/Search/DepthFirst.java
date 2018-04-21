
package Modle.Search;

import java.util.*;

public class DepthFirst {
    
    private final ArrayList<Node> states;
    private Node goal;
    private SubTree tree;
    
    
    public DepthFirst(Node goal){
        this.goal = goal;
        this.states = new ArrayList();
        this.tree = null;
        setStates(tree);
    }
    
    public DepthFirst(SubTree tree, Node goal){
        this.goal = goal;
        this.states = new ArrayList();
        this.tree = tree;
        setStates(tree);        
    }
    
    
    
    public SubTree getTree() {
        return tree;
    }
    public void setTree(SubTree tree) {
        this.tree = tree;
    }
    
    public Node getState(int index){
        return states.get( index );
    }
    public int len(){
        return states.size();
    }
    
    public Node getGoal() {
        return goal;
    }
    public void setGoal(Node goal) {
        this.goal = goal;
    }

    
    ///...priavte...\\\
    private void setStates(SubTree tree){
        states.add(tree.get());
        addStates(tree);
    }
    private void addStates(SubTree tree){
        for (int i = 0; i < tree.getChildren().size(); i++) {
            if(tree.getChildren().getChild(i) instanceof SubTree){
                states.add( tree.getChildren().getChild(i) );
                addStates( (SubTree)tree.getChildren().getChild(i) );
            }else{
                states.add(tree.getChildren().getChild(i));
                states.add(tree.get());
                continue;
            }
            states.add(tree.get());
        }
    }
    private boolean isAGoal( Node node ){
        return goal.getValue() == node.getValue();
    }



    
}