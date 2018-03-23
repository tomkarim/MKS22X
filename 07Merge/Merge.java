
public class Merge{

    public static void mergesort(int[] data){
	M(data, 0, data.length-1);
    }

    public static void Merge(int[] data, int lo, int mid, int hi){
	int[] temp = new int[data.length];
	for(int i = lo; i <= mid; i++){
	    temp[i] = data[i];
	}
	for(int j = mid+1; j <= hi; j++){
	    temp[mid+1+hi-j] = data[j];
	}
	int i = lo;
	for(int k = lo, j = hi; k <= hi; k++){
	    if(temp[j] < temp[i])
		data[k] = temp[j--];
	    else
		data[k] = temp[i++];
	}
    }

    public static void M(int[] data, int lo, int hi){
	    int mid = (lo+hi)/2;
	    if(hi <= lo){
		return;
	    }
	    M(data, lo, mid);
	    M(data, mid+1, hi);
	    Merge(data, lo, mid, hi);
    }
    
}
	    
