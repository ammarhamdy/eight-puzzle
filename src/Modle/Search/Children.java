
package Modle.Search;

import java.util.*;


 public class Children {
    
    
    private final ArrayList<Node> childrenList;
    private final ArrayList<Node> childrenNodeList;
    private final ArrayList<SubTree> childrenSubTreeList;
    
    public Children(){
        this.childrenList = new ArrayList();
        this.childrenNodeList = new ArrayList();
        this.childrenSubTreeList = new ArrayList();
    }
    
    public boolean add(Node node){
        return childrenList.add(node)
                && childrenNodeList.add(node);
    }
    public boolean addAll(Node... node){
        return childrenList.addAll(Arrays.asList(node))
                && childrenNodeList.addAll(Arrays.asList(node));        
    }
    public boolean remove(Node node) {
        return childrenList.remove(node)
                && childrenNodeList.remove(node);
    }
    
    
    public boolean add(SubTree subTree){
        return childrenList.add(subTree)
                && childrenSubTreeList.add(subTree);
    }
    public boolean addAll(SubTree... subTree){
        return childrenList.addAll(Arrays.asList(subTree))
                && childrenSubTreeList.addAll(Arrays.asList(subTree));
    }
    public boolean remove(SubTree subTree){
        return childrenList.remove(subTree)
                && childrenSubTreeList.remove(subTree);
    }
    
    
    public int nodesSize(){
        return childrenNodeList.size();
    }
    public int subTreesSize(){
        return childrenSubTreeList.size();
    }
    public int size(){
        return childrenList.size();
    }
    
    
    public Node getChild(int index){
        return childrenList.get(index);
    }
    public Node getNode(int index){
        return childrenNodeList.get(index);
    }
    public SubTree getSubTree(int index){
        return childrenSubTreeList.get(index);
    }
    
    
    public int indexOf(Node node){
        return childrenList.indexOf(node);
    }
    public int indexOf(SubTree subTree){
        return childrenList.indexOf(subTree);
    }
    
    
    public boolean hasNode(){
        return nodesSize()> 0;
    }
    public boolean hasSubTree(){
        return subTreesSize()> 0;
    }

    
}