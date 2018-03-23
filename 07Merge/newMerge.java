public class newMerge{

    public static void mergesort(int[] data){
	mh(data, 0, data.length-1);
    }

    public static void mh(int[] data, int lo, int hi){
	if(hi <= lo){
	    return;
	}
	int mid = lo + (hi - lo) / 2;
	mh(data, lo, mid);
	mh(data, mid+1, hi);
	merge(data, lo, mid, hi);
    }

    public static void merge(int[] data, int lo, int mid, int hi){
	int[] temp = new int[data.length];
	for(int i = lo; i <= hi; i++){
	    temp[i] = data[i];
	}
	int i = lo;
	int j = mid+1;
	int k = lo;

	while(i <= mid && j <= hi){
	    if (temp[i] <= temp[j]){
		data[k] = temp[i];
		i++;
	    } else {
		data[k] = temp[j];
		j++;
	    }
	    k++;
	}

	while(i <= mid){
	    data[k] = temp[i];
	    k++;
	    i++;
	}
    }
}
