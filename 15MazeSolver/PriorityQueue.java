public class PriorityQueue{
    MyHeap array;
    
    public PriorityQueue(){
	array = new MyHeap(false); 
    }

    public Location remove(){
	return array.remove();
    }
    
    public void add(Location x){
	array.add(x);
    }
}
