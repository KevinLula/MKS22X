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
	pushUpHelp(array.size() - 1);
    }

    private void pushDown(){
	pushDownHelp(1);
    }

    public String toString(){
	String res = "[";
	for(int i = 1; i <= size; i++){
	    res += array.get(i) + " ";
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
