public class Quick{
    public static void quicksort(int[] ary){
	quickhelp(ary, 0, ary.length-1);
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
	    else if(ary[i] < pivot){
		swap(ary, i, lt);
		lt++;
		i++;
	    }
	    else {
		swap(ary, i, gt);
		gt--;
	    }
	}
	
