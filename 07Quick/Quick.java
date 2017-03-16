import java.util.Random;
public class Quick{
    public static void swap(int[]data, int a, int b){
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }
    
    public static int part(int[] data, int start, int end){
	int pivot = new Random().nextInt(data.length);
	swap(data, pivot, end - 1);
	int begin = start;
	for(int i = start; i < end - 1; i++){
	    if(data[i] < data[end-1]){
		swap(data, begin, i);
		begin+=1;	      
	    }
	}
	swap(data, begin, end-1);
	return begin;		
    }

    public static int quickselect(int[]data, int k){
	return quickH(data, k, 0, data.length);
    }

    public static int quickH(int[]data, int k, int start, int end){
	int index = part(data, 0, data.length);
	if (index == k){
	    return data[k];
	}
	if(k > index){
	    return quickH(data, k, start, index-1);
	}
	else{
	    return quickH(data, k, index-1, end);
	}
    }
    //Start and end of the method currently do not have any function in the method.
    //Though they will be used to dicide the array so that the area of search is diminished.
    //Currently it is merely randomly searching for the value.
}
	
