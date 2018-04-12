import java.util.*;
import java.lang.*;

public class MyLinkedListImproved<T>{
    private Node start, end; 
    private int size = 0;

    public MyLinkedListImproved(){
    }

    private class Node{
        Node next = null, prev = null;
        Integer value;

        public Node(int value){
            this.value = value;
        }

        public String toString(){
            return value + "";
        }
    }

    private Node getNode(int index){
        Node current;
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(index <= size/2){
            current = start;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
        }
        else{
            current = end;
            for(int i = size-1; i > index; i--){
                current = current.prev;
            }
        }
        return current;
    }

    public String toString(){
        String str = "[";
        Node current = start;
        for (int i = 0; i < size; i++){
            str += current.toString() + " , ";
            current = current.next;
        }
        return str + "]";
    }
    
    public void clear(){
        size = 0;
        start = null;
        end = null;
    }

    public int size(){
        return size;
    }

    public Integer get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).value;
    }

    public Integer set(int index, Integer value){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node n = getNode(index);
        Integer old = n.value;
        n.value = value;
        return old;
    }

    public int indexOf(Integer value){
        Node current = start;
        for(int i = 0; i < size; i++){
            if(current.value.equals(value)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public boolean add(Integer newData){
        Node nNode = new Node(newData);
        if(size == 0) {
            start = nNode;
        }
        else{
            nNode.prev = end;
            end.next = nNode;
        }
        end = nNode;
        size++;
        return true;
    }
    
    public void add(int index, Integer value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        Node nNode = new Node(value);

        if(size == 0){
            start = nNode;
            end = nNode;
        }
        else if(index == 0){
            start.prev = nNode;
            nNode.next = start;
            start = nNode;
        }
        else if(index == size){
            end.next = nNode;
            nNode.prev = end;
            end = nNode;
        }
        else{
            Node curr = getNode(index - 1);
            nNode.prev = curr;
            nNode.next = curr.next;
            curr.next.prev = nNode;
            curr.next = nNode;
        }
        size++;
    }

    public boolean remove(Integer value){
        int count = 0;
        for(int i = 0; i < size; i++){
            if(indexOf(value) != 0){
                remove(i);
                count++;
            }
        }
        size -= count;
        return true;
    }

    public Integer remove(int index){
        Integer old;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            old = start.value;
            start = start.next;
            start.prev = null;
        }
        else if(index == size-1){
            old = end.value;
            end = end.prev;
            end.next = null;
        }
        else{
            Node n = getNode(index);
            old = n.value;
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        size--;
        return old;
    }

    public int max(MyLinkedListImproved<T> implements Comparable<T>){
	return size; // for now
    }

    public int min(MyLinkedListImproved<T> implements Comparable<T>){
	return size; // for now
    }


}
