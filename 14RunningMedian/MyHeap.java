import java.util.*;
public class MyHeap{

    private int direction;
    private int size;
    private ArrayList<Integer> array;

    public MyHeap(){	
	array = new ArrayList<Integer>;
	size = 0;
    }

    public MyHeap(boolean x){
	if(x){
	    array = new ArrayList<Integer>;
            array.set(0,null);
	    direction = 1;
	}
	else{
	    array = new ArrayList<Integer>;
            array.set(0,null);
	    direction = -1;
	}
    }

    public void add(int s){
	size++;
	array.set(size,s);
	pushUp();
    }

    public int remove(){
       if(size < 1){
	    throw new IllegalArgumentException();
	}
	int removed = array.get(1);
	array.set(1,array.get(size));
	size -= 1;
	pushDown();
	return removed;
    }

    public int peek(){
        if(size < 1){
	    throw new IllegalArgumentException();
	}
	int res = array.get(1);
	return res;
    }

    private void pushUp(){
	int x = size;
	int parent = x / 2;
	while (x > 1 && (direction * (array.get(x) - array.get(parent))) > 0){
		int temp = array.get(parent);
		array.set(parent,array.get(x));
		array.set(x,temp);
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
	    if((direction * (array.get(left) - array.get(right))) > 0){
	    chosen = left;
	}
	else{chosen = right;}
	}
	while(parent < size && right < size && (direction * (array[parent] - array[chosen])) < 0){
	    int temp = array[parent];
	    array[parent] = array[chosen];
	    array[chosen] = temp;
	    parent = chosen;
	    left = chosen * 2;
	    right = chosen * 2 + 1;
	if(right < size){
	    if((direction * (array[left] - array[right])) > 0){
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
	a.add(1);
	System.out.println(a);
	a.add(2);
	System.out.println(a);
	a.add(3);
	System.out.println(a);
	a.add(4);
	System.out.println(a);
	a.add(5);
	System.out.println(a);
	a.add(6);
	System.out.println(a);
	a.add(7);
	System.out.println(a);
	a.add(8);
	System.out.println(a);
	a.add(9);
	System.out.println(a);
	a.add(10);
	System.out.println(a);
	a.add(11);
	a.remove();
	System.out.println(a);
	a.remove();
	System.out.println(a);
    }
}

//Use a while loop instead of helper fuctions to make the pushUp and pushDown functions.
