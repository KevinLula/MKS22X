import java.util.*;
import java.io.*;
public class Merge{

    public static void mergesort(int[]ary){
	if (ary.length <= 1){
	    return;
	}
	else{
	    int[] left = new int[ary.length / 2];
	    int[] right = new int[ary.length - a.length];
	    int lIndex = 0;
	    for (int lIndex = 0; lIndex < ary.length; lIndex++){
		if (lIndex < left.length){
		    left[lIndex] = ary[lIndex];
		}
		else{
		    right[rIndex] = ary[rIndex];
		    rIndex += 1;
		}
	    }
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}

	    
    }

    private static void merge(int[]a, int[]b, int[] destination){
	int x = 0;
	int y = 0;
	int z = 0;	
	while (x <= a.length && y <= b.length){
	    if (x == a.length){
		destination[z] = b[y];
		y++;
		z++;
	    }
	    else if (y == b.length){
		destination[z] = a[x];
		x++;
		z++;
	    }
	    else if (a[x] <= b[y]){
		destination[z] = a[x];
		x++;
		z++;
	    }
	    else if(b[y] < a[x]){
		destination[z] = b[y];
		y++;
		z++;
	    }
	}
    }		
}
