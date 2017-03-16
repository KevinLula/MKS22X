import java.util.Random;
public class Quick{
    
    public static int part(int[] data, int start, int end){
	int pivot = new Random().nextInt(end - start + 1) + start;
	int temp = data[end - 1];
	data[end - 1] = data[pivot];
	data[pivot] = temp;
	int begin = start;
	for(int x = start; x < end; x++){
	    if(data[x] < data[end - 1]){
		int temp2 = data[begin];
		data[begin] = data[x];
		data[x] = temp2;
		begin += 1;
	    }
	}
	    temp = data[begin];
	    data[begin] = data[end - 1];
	    data[end - 1] = temp;
	    return begin;
    }

    public static int quickselect(int[]data, int k){
	int index = part(data, 0, data.length - 1);
	while(k != index){
	    if(index > k){
		index = part(data, 0, index + 1);
	    }
	    if(index < k){
		index = part(data, index + 1, data.length - 1);
	    }
	}
	return data[k];
    }

}


	