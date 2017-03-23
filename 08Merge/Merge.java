public class Merge{

    public static void merge(int[]a, int[]b, int[]destination){
	mergeH(a, b, destination, 0, 0, 0);
    }

    private static void mergeH(int[]a, int[]b, int[]destination, int x, int y, int z){
	if(x < a.length || y < b.length){
	    if(y > b.length - 1){
		destination[z] = b[x];
		mergeH(a, b, destination, x++, y, z++);
	    }
	    if(x > a.length - 1){
		destination[z] = b[y];
		mergeH(a, b, destination, x, y++, z++);
	    }		
	    if(a[x] > b[y]){
	    destination[z] = b[y];
	    mergeH(a, b, destination, x, y++, z++);
	    }
	    if(a[x] <= b[y]){
	    destination[z] = a[x];
	    mergeH(a, b, destination, x++, y, z++);
	    }
	}
    }

    public static void main(String[] args){
	int[] a = {1, 3, 6, 9, 13};
	int[] b = {2, 5, 7, 10};
	int[] c = new int[9];
	merge(a, b, c);
	String s = "";
	for(int x = 0; x < c.length; x++){
	    s += c[x];
	}
	System.out.println(s);
    }
	
}
