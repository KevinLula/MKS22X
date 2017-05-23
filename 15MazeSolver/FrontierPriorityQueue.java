public class FrontierPriorityQueue implements Frontier{
    private PriorityQueue locations;
    private int size;

    public FrontierPriorityQueue(){
	locations = new PriorityQueue();
	size = 0;
    }
   
    public void add(Location x){
	locations.add(x);
	size++;
    }

    public Location next(){
	size--;
	return locations.remove();
    }

    public int getSize(){
	return size;
    }
}
