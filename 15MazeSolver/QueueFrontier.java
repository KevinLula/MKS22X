import java.util.*;
public class QueueFrontier implements Frontier{
    
    private LinkedList<Location> locations;
    private int size;
    
    public QueueFrontier(){
	locations = new LinkedList<Location>();
    }
    
    public void add(Location x){
	locations.add(x);
	size++;
    }
    
    public Location next(){
	size--;
	return locations.remove();
    }
    
    public boolean hasNext(){
	return !locations.isEmpty();
    }

    public int size(){
	return size;
    }
    
}
