import java.util.*;
public class MyHeap{

    private int direction;
    private int size;
    private int[] array;

    public MyHeap(){	
	array = new int[10];
	size = 0;
    }

    public MyHeap(boolean x){
	if(x){
            array = new int[10];
	    direction = 1;
	}
	else{
           array = new int[10];
	    direction = -1;
	}
    }

    public int getSize(){
	return size;
    }

    public void add(int s){
	if(array.length - 1 == size){
	int[] temp = new int[array.length * 2];
	for(int x = 0; x < array.length; x++){
	temp[x] = array[x];
	}
	array = temp;
	}
	array[size] = s;
	size++;
	pushUp();
    }

    public int remove(){
       if(size < 1){
	    throw new IllegalArgumentException();
	}
	int removed = array[0];
	array[0] = array[size - 1];
	size -= 1;
	pushDown();
	return removed;
    }

    public int peek(){
        if(size < 1){
	    throw new IllegalArgumentException();
	}
	int res = array[0];
	return res;
    }

    private void pushUp(){
	int x = size - 1;
	int parent = (x + 1)/2 - 1;
	while (x > 0 && (direction * (array[x] - array[parent])) > 0){
		int temp = array[parent];
		array[parent] = array[x];
		array[x] = temp;
		x = parent;
		parent = (parent + 1)/2 - 1;
	    }
		
	       }

    private void pushDown(){
	int parent = 0;
	int left = (parent + 1) * 2 - 1;
	int right = (parent + 1) * 2;
	int chosen = 0;
	if(right < size){
	    if(direction * (array[left] - array[right]) > 0){
	    chosen = left;
	}
	else{chosen = right;}
	}
	while(parent < size && right < size && direction * (array[parent] - array[chosen]) < 0){
	    int temp = array[parent];
	    array[parent] = array[chosen];
	    array[chosen] = temp;
	    parent = chosen;
	    left = (chosen + 1) * 2 - 1;
	    right = (chosen + 1) * 2;
	if(right < size){
	    if(direction * (array[left] - array[right]) > 0){
	    chosen = left;
	}
	else{chosen = right;}
	}
	}
    }




    public String toString(){
	String res = "[";
	for(int i = 0; i < size; i++){
	    if(i == size - 1){
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
	MyHeap a = new MyHeap(false);
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
	System.out.println(a);
	a.remove();
	System.out.println(a);
	a.remove();
	System.out.println(a);
	System.out.println(a.peek());
	System.out.println(a.getSize());
    }
}

//Use a while loop instead of helper fuctions to make the pushUp and pushDown functions.
