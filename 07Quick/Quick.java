public class Quick{

    public static int quickSelect(int[] data, int k){
	new int[] temporary;
	if(part(data, 0, data.length-1) == k){
	    return temporary[k];
	}
	else{quickSelect(data, k);}
    }
	
