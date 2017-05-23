import java.util.*;
public class StackFrontier implements Frontier{
    
    private Stack<Location> locations = null;
    private int size;

    public StackFrontier(){
	locations = new Stack<Location>();
	size = 0;
    }
    
    public void add(Location x){
	locations.push(x);
	size++;
    }
    
    public Location next(){
	size--;
	return locations.pop();
    }
    
    public boolean hasNext(){
	return !locations.isEmpty();
    }

    public int getSize(){
	return size;
    }
    
}
