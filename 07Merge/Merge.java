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

    public st
	    
