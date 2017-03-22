import java.util.Random;
public class Quick{
    
	public static int part(int[] data, int start, int end){
	    int pivot = new Random().nextInt(end - start) + start;
	    int pivotNum = data[pivot];
	    int temp = data[start];
	    data[start] = data[pivot];
	    data[pivot] = temp;
	    int lt = start;
	    int i = start + 1;
	    int gt = end - 1;
	    while(i <= gt){
		if(data[i] == pivotNum){
		    i++;
		}
		else if(data[i] < pivotNum){
		    int temp2 = data[i];
		    data[i] = data[lt];
		    data[lt] = temp2;
		    lt++;
		    i++;
		}
		else{
		    int temp3 = data[i];
		    data[i] = data[gt];
		    data[gt] = temp3;
		    gt--;
		}
	    }
	    int temp4 = data[gt];
	    data[gt] = data[lt];
	    data[lt] = temp4;
	    return lt;
	}

    public static int quickselect(int[] data, int k){
	return quickselectH(data, k, 0, data.length);
    }

    private static int quickselectH(int[]data, int k, int small, int large){
	int index = part(data, small, large);
	int lesserK = small;
	int biggerK = large;
	if(k < index){
	    biggerK = index;
	    quickselectH(data, k, lesserK, biggerK);
	}
	if(k > index){
	    lesserK = index;
	    quickselectH(data, k, lesserK, biggerK);
	}
	return data[k];
    }

    private static int[] quickSortH(int[] data, int start, int end){
	if(start < end){
	    int index = part(data, start, end);	    
	    quickSortH(data, start, index);
	    quickSortH(data, index + 1, end);
	}
	return data;
    }

    public static String quickSort(int[] data){
	int[] temp = quickSortH(data, 0, data.length);
	String res = "";
	for(int x = 0; x < temp.length; x++){
	    res += temp[x];
	}
	return res;
    }
	
	    
	public static void main(String[] args){
	    int[] a = {0, 4, 1, 2, 5, 3, 2};
	    int[] b = {0, 4, 1, 2, 5, 3, 2};
	    int[] c = {0, 2, 1, 2, 3};
	System.out.println(part(a, 0, a.length));
		String s = "";
	String t = "";
	for(int x = 0; x < a.length; x++){
	s += a[x];
	}
	System.out.println(s);
	/*	System.out.println(quickselect(b, 2));
	for(int x = 0; x < b.length; x++){
	t += b[x];
	}
	System.out.println(t);
	System.out.println(quickSort(c));
	*/	}

}


	
