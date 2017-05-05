import java.util.*;
public class MyHeap{

    private int direction;
    private int size;
    private String[] array;

    public MyHeap(){	
	array = new String[10];
	size = 0;
    }

    public MyHeap(boolean x){
	if(x){
            array = new String[10];
            array[0] = null;
	    direction = 1;
	}
	else{
           array = new String[10];
           array[0] = null;
	    direction = -1;
	}
    }

    public void add(String s){
	if(array.length - 1 == size){
	String[] temp = new String[array.length * 2];
	for(int x = 0; x < array.length; x++){
	temp[x] = array[x];
	}
	array = temp;
	}
	size += 1;
	array[size] = s;
	pushUp();
    }

    public String remove(){
       if(size < 1){
	    throw new IllegalArgumentException();
	}
	String removed = array[1];
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
	while (x > 1 && (direction * array[x].compareTo(array[parent])) > 0){
		String temp = array[parent];
		array[parent] = array[x];
		array[x] = temp;
		x = parent;
		parent = parent / 2;
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
	            array[parent] = temp;
		    parent = 2;
	    }
		else{
		    if(array[parent].compareTo(array[childRight]) * direction < 0){
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
	MyHeap x = new MyHeap(true);
	x.add("a");
	x.add("b");
	x.add("c");
	x.add("d");
	x.add("e");
	x.add("f");
	x.add("g");
	String a = x.remove();
	String b = x.remove();
	String c = x.peek();
	System.out.println(x);
	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
    }
}

//Use a while loop instead of helper fuctions to make the pushUp and pushDown functions.
