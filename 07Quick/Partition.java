public class Partition{
    public static int part(int [] data, int start, int end){
	int[] temp = new int[end - start + 1];
	int pivot = new Random().nextInt(end - start) + start;
	int pivotValue = data[pivot];
	int begin = 0;
	int last = data.length - 1;
	for(int x = start; start <= end; x++){
	    if(x != pivot){
		if(data[x] <= pivotValue){
		    temp[begin] = data[x];
		    begin += 1;
		}
		else{temp[last] = data[x];
		    last -= 1;
		}
	    }
	}
	temp[begin] = data[pivot];
	return begin + start;
    }
}
	
