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
	size++;
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
	String res = array[1];
	return res;
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
	int left = parent * 2;
	int right = parent * 2 + 1;
	int chosen = 0;
	if(right < size){
	    if(direction * array[left].compareTo(array[right]) > 0){
	    chosen = left;
	}
	else{chosen = right;}
	}
	while(parent < size && right < size && direction * (array[parent].compareTo(array[chosen])) < 0){
	    String temp = array[parent];
	    array[parent] = array[chosen];
	    array[chosen] = temp;
	    parent = chosen;
	    left = chosen * 2;
	    right = chosen * 2 + 1;
	if(right < size){
	    if(direction * array[left].compareTo(array[right]) > 0){
	    chosen = left;
	}
	else{chosen = right;}
	}
	}
    }




    public String toString(){
	String res = "[";
	for(int i = 1; i <= size; i++){
	    if(i == size){
		res += array[i];
	    }
	    else{
	    res += array[i] + " ";
	    }
	}
	res += "]";
	return res;
    }
	
    public static void main(String[] args){
	MyHeap a = new MyHeap(true);
	a.add("a");
	System.out.println(a);
	a.add("b");
	System.out.println(a);
	a.add("c");
	System.out.println(a);
	a.add("d");
	System.out.println(a);
	a.add("e");
	System.out.println(a);
	a.add("g");
	System.out.println(a);
	a.add("f");
	System.out.println(a);
	a.add("h");
	System.out.println(a);
	a.add("h");
	System.out.println(a);
	a.add("h");
	System.out.println(a);
	a.add("h");
	System.out.println(a);
	a.add("h");
	System.out.println(a);
	a.add("h");
	System.out.println(a);
	a.remove();
	System.out.println(a);
	a.remove();
	System.out.println(a);
    }
}

//Use a while loop instead of helper fuctions to make the pushUp and pushDown functions.
