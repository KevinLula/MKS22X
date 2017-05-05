import java.util.ArrayList;
public class MyHeap{

    private int direction;
    private int size;
    private ArrayList<String> array;

    public MyHeap(){	
	direction = 1;
	array.add(null);
	size = 0;
    }

    public MyHeap(boolean x){
	if(x){
	    array.add(null);
	    direction = 1;
	    size = 0;
	}
	else{
	    array.add(null);
	    direction = -1;
	    size = 0;
	}
    }

    public void add(String s){
	size += 1;
	array.add(s);
	pushUp();
    }

    public String remove(){
        String res = array.get(1);
	array.set(1, array.get(size));
	pushDown();
	return res;
    }

    public String peek(){
	return array.get(1);
    }

    private void pushUp(){
	pushUpHelp(array.size() - 1);
    }

private void pushUpHelp(int x){
	String str = array.get(x);
	if(x > 1){
	if(str.compareTo(array.get(x/2)) >= 1){
	    array.set(x,array.get(x/2));
	    array.set(x/2, str);
	pushUpHelp(x/2);
	}
}
}

    private void pushDown(){
	pushDownHelp(1);
    }

	private void pushDownHelp(int x){
	if(x < array.size() - 1){
	String parent = array.get(x);
	String childLeft = array.get(2 * x);
	String childRight = array.get(2 * x + 1);
	if(childLeft.compareTo(childRight) >= 1){
	if(parent.compareTo(childLeft) >= 1){
	    array.set(2 * x,parent);
	    array.set(x, childLeft);
	pushDownHelp(2 * x);
	}
}
	else{
	if(parent.compareTo(childRight) >= 1){
	    array.set(2 * x + 1, parent);
	    array.set(x, childRight);
	pushDownHelp(2 * x + 1);
	}
}
}
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
