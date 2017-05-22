import java.util.*;
public class MyHeap{

    private int direction;
    private int size;
    private ArrayList<Location> array;

    public MyHeap(){	
	array = new ArrayList<Location>();
	array.add(null);
	size = 0;
	direction = 1;
    }

    public MyHeap(boolean x){
	if(x){
	array = new ArrayList<Location>();
	array.add(null);
        direction = 1;
	size = 0;
	}
	else{
	array = new ArrayList<Location>();
	array.add(null);
        direction = -1;
	size = 0;
	}
    }

    public int size(){
	return size;
    }

    public Location peek(){
	return array.get(1);
    }

    public void add(Location x){
	size++;
	array.add(x);
	pushUp();
    }

    public Location remove(){
       if(size == 1){
	   size--;
	   return array.remove(1);
       }
       else{
	   Location temp = array.get(1);
	   array.set(1, array.remove(size));
	   size--;
	   pushDown();
	   return temp;
       }
    }

    private void pushUp(){
	int x = size;
	int parent = x / 2;
	while (x > 1 && (direction * (array.get(x)).compareTo(array.get(parent))) > 0){
	    Location temp = array.get(parent);
	    array.set(parent, array.get(x));
	    array.set(x, temp);
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
	    if(direction * (array.get(left)).compareTo(array.get(right)) > 0){
	    chosen = left;
	}
	else{chosen = right;}
	}
	while(parent < size && right < size && direction * ((array.get(parent)).compareTo(array.get(chosen))) < 0){
	    Location temp = array.get(parent);
	    array.set(parent, array.get(chosen));
	    array.set(chosen, temp);
	    parent = chosen;
	    left = chosen * 2;
	    right = chosen * 2 + 1;
	if(right < size){
	    if(direction * (array.get(left)).compareTo(array.get(right)) > 0){
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
		res += array.get(i);
	    }
	    else{
		res += array.get(i) + " ";
	    }
	}
	res += "]";
	return res;
    }
}
