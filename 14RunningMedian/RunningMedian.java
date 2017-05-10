public class RunningMedian{

    private int median;
    private MyHeap min, max;
    private boolean hasMedian;

    public RunningMedian(){
	max = new MyHeap(true);
	min = new MyHeap(false);
	hasMedian = false; 
    }

    public void add(int x){
	if (!hasMedian){
	    median = x;
	    hasMedian = true;
	}
	else if(min.getSize() == max.getSize()){
	    if (x < median){
		max.add(x);}
	    else{
		min.add(x);}
	}
	else if(max.getSize() > min.getSize()){
	    if (x < median){
		max.add(x);
		min.add(median);
		median = max.remove();
	    }
	    else{
		min.add(x);
	    }
	}
	else{
	    if(x > median){
		min.add(x);
		max.add(median);
		median = min.remove();
	    }
	    else{
		max.add(x);
	    }
	}
    }
	
    
    
    public double getMedian(){
	if (min.getSize() == max.getSize()){
	    return median;
	}
	if (min.getSize() > max.getSize()){
	    return (min.peek() + median) / 2.0;
	}
	else{
	    return (max.peek() + median) / 2.0;
	}
    }

    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
	System.out.println(a.getMedian());
	a.add(1);
	System.out.println(a.getMedian()); // 1
	a.add(3);
	System.out.println(a.getMedian()); // 2
	a.add(9);
	a.add(2);
	a.add(20);
	System.out.println(a.getMedian()); // 3
	a.add(25);
	a.add(21);
	System.out.println(a.getMedian()); // 9
    }
}
    
