import java.util.ArrayList;
public class MyHeap{

    private int constant;
    private ArrayList<String> array;

    public MyHeap(){
	constant = 1;
	array.add("null");
    }

    public MyHeap(boolean x){
	if(x){
	    array.add("null");
	    constant = 1;
	}
	else{
	    array.add("null");
	    constant = -1;
	}
    }

    public void add(String s){
	array.add(s);
	pushUp();
    }

    public String remove(){
	return array.remove();
	pushDown();
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
	array.set(x) = array.get(x/2);
	array.set(x/2) = str;
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
	array.set(2 * x) = parent;
	array.set(x) = childLeft;
	pushDownHelp(2 * x);
	}
}
	else{
	if(parent.compareTo(childRight) >= 1){
	array.set(2 * x + 1) = parent;
	array.set(x) = childRight;
	pushDownHelp(2 * x + 1);
	}
}
}
}
}

//Use a while loop instead of helper fuctions to make the pushUp and pushDown functions.
