public class Merge{

    public static void Merge(int[] data, int lo, int mid, int hi){
	int[] temp = temp[data.length];
	for(int i = lo; i <= mid; i++)
	    temp[i] = data[i];

	for(int j = mid+1; j <= hi; j++)
	    temp[mid+1+hi-j] = data[j];

	for(int i = int k = low, j = hi; k <= stop; k++)
	    if(temp[j] < temp[i])
		data[k] = extra[j--];
	    else
		data[k] = extra[i++];
    }

    public static void M(int[] data, int lo, int hi){
	    int mid = (lo+hi)/2;
	    if(hi <= lo){
		    return data;
	    }
	    M(data, lo, mid);
	    M(data, mid+1, hi);
	    Merge(data, lo, mid, hi);
    }
	    
