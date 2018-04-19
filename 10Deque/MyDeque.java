public class MyDeque<E>{
    private E[] data;
    private int size;
    private int start;
    private int end;

    @SuppressWarnings("unchecked")

    public MyDeque(){
	data =(E[])new Object[10];
	size = 10;
	start = 0;
	end = 9;
  }

    public MyDeque(int intcap){
	data = (E[])new Object[intcap];
	size = intcap;
	int start = 0;
	int end = intcap-1;
    }

    public int size(){
	return size;
    }

    public void addFirst(E e){

    }

    public void addLast(E e){

    }

    public E getFirst(){
	return E[start];
    }

    public E getLast(){
	return E[end];
    }
    
}
