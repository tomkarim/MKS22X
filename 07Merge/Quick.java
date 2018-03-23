import java.util.*;

public class Quick{
    public static void quicksort(int[] ary){
	quickhelp(ary, 0, ary.length-1);
    }

    public static void swap(int[] ary, int x, int y){
	int temp = ary[x];
	ary[x] = ary[y];
	ary[y] = temp;
    }

    public static void quickhelp(int[] ary, int lo, int hi){
	Random rng = new Random();
	int index = lo + rng.nextInt(hi-lo+1);
	int pivot = ary[index];
	int i = lo;
	int lt = lo;
	int gt = hi;
	
	swap(ary, index, lo);

	while(i <= gt){
	    if(ary[i] == pivot){
		i++;
	    }
	    else if(ary[i] > pivot){
		swap(ary, i, gt);
		gt--;
	    }
	    else {
		swap(ary, i, lt);
		lt++;
		i++;
	    }
	}
	quickhelp(ary, lo, lt-1);
	quickhelp(ary, gt+1, hi);
    }

    public static int part(int[] ary, int lo, int hi){
	Random rng = new Random();
	int index = lo + rng.nextInt(hi-lo+1);
	int pivot = ary[index];
	int i = lo;
	int lt = lo;
	int gt = hi;
	
	swap(ary, index, lo);

	while(i <= gt){
	    if(ary[i] == pivot){
		i++;
	    }
	    else if(ary[i] > pivot){
		swap(ary, i, gt);
		gt--;
	    }
	    else {
		swap(ary, i, lt);
		lt++;
		i++;
	    }
	}
	return (lt+gt)/2;
    }

    public static int quickselect(int[] ary, int k){
	int lo = 0;
	int hi = ary.length-1;
	int i = part(ary, 0, ary.length-1);

	while(i != k){
	    if(i < k){
		lo = i++;
		i = part(ary, lo, hi);
	    } else {
		hi = i--;
		i = part(ary, lo, hi);
	    }
	}
	return ary[i];
    }
}
    
    
	
	
