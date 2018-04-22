
package Test;

import Modle.Search.Node;
import Modle.Search.SubTree;
import Modle.Search.TilesTree;
import java.util.*;


public class BeadthFirst {
    
    private final ArrayList<Node> states;
    private Node goal;
    private SubTree tree;
    private final Queue<Node> queue;
    
    public BeadthFirst(Node goal){
        this.goal = goal;
        this.states = new ArrayList();
        this.tree = null;
        queue = new LinkedList();
    }
    
    public BeadthFirst(SubTree tree, Node goal){
        this.goal = goal;
        this.states = new ArrayList();
        this.tree = tree;
        queue = new LinkedList();
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
    boolean hasLavel = true;
    private boolean addStates(SubTree tree){
        ArrayList<SubTree> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < tree.getChildren().size(); j++) {
                queue.add((Node) tree.getChildren().getChild(j));
                states.add(queue.remove() );
                temp.add((SubTree)tree.getChildren().getChild(j));
            }
            temp.clear();
        }

        return true;
    }
    
    
    
    private boolean isAGoal( Node node ){
        return Arrays.equals( (byte[])goal.getValue() , (byte[])node.getValue() );
    }


    
    public static void main(String[] args) {
        
        TilesTree tree = new TilesTree();
        BeadthFirst ff = new BeadthFirst(tree.get() , null);
        ff.addStates(tree.get());
        for (int i = 0; i < ff.len(); i++) {
            System.out.println( Arrays.toString( (byte[]) ff.getState(i).getValue() ) );
        }
        
    }
    
    
    
}
