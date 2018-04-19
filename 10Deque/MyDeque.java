public class MyDeque<E>{
    private E[] data;
    private int size;
    private int start;
    private int end;

    @SuppressWarnings("unchecked")

    public MyDeque(){
	data =(E[])new Object[10];
	size = 10;
  }

    public MyDeque(int intcap){
	data = (E[])new Object[intcap];
	size = intcap;
    }

    public int size(){
	return size;
    }

    public void addFirst(E e){

    }

    public void addLast(){

    }

    public E removeFirst(){

    }

    public E removeLast(){
	
    }

    public E getFirst(){
	return E[start];
    }

    public E getLast(){
	return E[end];
    }
    
}
