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
    }

    public String remove(){
    }

    public String peek(){
    }

    private void pushUp(){
	//if the value is smaller than the next top value then you stop.
    }

    private void pushDown(){
	if(this.compareTo(
			  //if the value is greater than the next two bottom values then u stop.
    }
