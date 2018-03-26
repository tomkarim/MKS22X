
public class Merge{

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	mergesort(data, temp, 0, data.length);
    }

    public static void mergesort(int[] data, int[] temp, int l, int r){
	if(r<=l+1){
	    return;
	}
	int m = l+(r-l)/2;
	mergesort(data, temp, l, m);
	mergesort(data,temp, m, r);
	merge(data, temp, l, m, r);
    }

    public static void merge(int[] data, int[] temp, int l, int m, int r){
	for(int k = l; k < r; k++){
	    temp[k] = data[k];
	}
	int i = l;
	int j = m;
	for(int k = l; k<r; k++){
	    if(i >= m){
		data[k] = temp[j++];
	    }else if(j >= r){
		data[k] = temp[i++];
	    }else if(temp[j] < temp[i]){
		data[k] = temp[j++];
	    }else
		data[k] = temp[i++];
	}
    }
}
	    
