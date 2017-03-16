import java.util.Random;
public class Partition{
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
}

	
