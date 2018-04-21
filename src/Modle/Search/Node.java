
package Modle.Search;


public class Node<T> {
    
    private T value;
    
    public Node(){
        value =null;
    }
    
    public Node(T value){
        this.value = value;
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
    
        
    
}
