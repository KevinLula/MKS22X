import java.util.*;
public class MyHeap{

    private int direction;
    private int size;
    private String[] array;

    public MyHeap(){	
	array = new String[10]
	size = 0;
    }

    public MyHeap(boolean x){
	if(x){
	    direction = 1;
	}
	else{
	    direction = -1;
	}
    }

    public void add(String s){
	array[size+=1] = str
	size += 1;
	pushUp();
    }

    public String remove(){
       if(size < 1){
	    throw new IllegalArgumentException();
	}
	String removed = heaparray[1];
	array[1] = array[size];
	size -= 1;
	pushDown();
	return removed;
    }

    public String peek(){
        if(size < 1){
	    throw new IllegalArgumentException();
	}
	return array[1];
    }

    private void pushUp(){
	int x = size;
	int parent = x / 2;
	while (x > 1 && (direction * array[x].compareTo(array[parent]) > 0){
		String temp = array[parent];
		array[parent] = array[x];
		array[x] = temp;
		x = parent;
		parent /= 2;
	    }
		
	       }

    private void pushDown(){
	int parent = 1;
	int childLeft = 2*parent;
	int childRight = 2*parent+1;
	String str = "";
	while (parent < size){
	    if (childLeft > size){
		break;
	    }
	    else if (array[parent].compareTo(array[childLeft]) * direction < 0){
                    String temp = array[childLeft];
	            array[childLeft] = array[parent];
	            heaparray[parent] = temp;
		    parent = 2;
	    }
		else{
		    if(heaparay[ind].compareTo(heaparray[childb]) * direction < 0){
	                String temp = array[childRight];
	                array[childRight] = array[parent];
	                array[parent] = temp;
			parent = 2*parent+1;
		    }
		}
		    
	}
    }

    public String toString(){
	String res = "[";
	for(int i = 1; i <= size; i++){
	    res += array[i] + " ";
	}
	res += "]";
	return res;
    }
	
    public static void main(String[] args){
	MyHeap x = new MyHeap();
	x.add("a");
	x.add("b");
	x.add("c");
	System.out.println(x);
    }
}

//Use a while loop instead of helper fuctions to make the pushUp and pushDown functions.
