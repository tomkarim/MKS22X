import java.util.*;

public class MyLinkedList{
    private Node start,end;
    private int size;

    public MyLinkedList(){

    }

    public class Node{
        Node pre, post;
    }

    //This method will help you write other
    //methods, it is private to protect your list
    private Node getNode(int index);

    public String toString(){
        String str = "[";
        Node curr = start;
        for (int i = size; i > 0; i--){
            str += curr.toString() + " , ";
            curr = curr.getNext();
        }
        return str + "]";
    }
    public void clear();
    public int size();
    public Integer get(int index);//exceptions!
    public Integer set(int index, Integer value);//exceptions!

    public int indexOf(Integer value);

    public boolean add(Integer newData){
        return add(size, newData);
    }
    public void add(int index, Integer value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        Node n = new Node(value);

        if(size == 0){
            start = n;
            end = n;
        }
    }

    //The remove methods can cause a problem, this is why we shouldn't
    //use an int as the data, we need objects to distinguish between index and data
    public boolean remove(Integer value);
    public Integer remove(int index);//exceptions! // returns the value of what you removed.


}
