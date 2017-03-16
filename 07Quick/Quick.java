import java.util.Random;
public class Quick{
    
    public static int part(int[] data, int start, int end){
	int pivot = new Random().nextInt(end - start) + start;
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
	    int temp3 = data[begin];
	    data[begin] = data[end - 1];
	    data[end - 1] = temp3;
	    return begin;
    }

    public static int quickselect(int[]data, int k){
	int index = part(data, 0, data.length - 1);
	int temp[] = new int[data.length];
	for(int x = 0; x < data.length; x++){
	temp[x] = data[x];
	}
	while(k != index){
	    if(index > k){
		index = part(temp, 0, index + 1);
	    }
	    if(index < k){
		index = part(temp, index + 1, temp.length - 1);
	    }
	}
	return temp[k];
    }

	public static void main(String[] args){
	int[] a = {0, 4, 1, 5, 3, 2};
	System.out.println(part(a, 0, a.length));
	String s = "";
	String b = "";
	for(int x = 0; x < a.length; x++){
	s += a[x];
	}
	System.out.println(s);
	System.out.println(quickselect(a, 2));
	for(int x = 0; x < a.length; x++){
	b += a[x];
	}
	System.out.println(b);	
}

}


	
