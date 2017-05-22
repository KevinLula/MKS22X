public class Location implements Comparable<Location>{
    private int row;
    private int col;
    private Location previous;
    private int distToStart;
    private int distToGoal;
    private boolean aStar;


    public Location(int r, int c, Location prev, int toStart, int toGoal){
	row = r;
	col = c;
	previous = prev;
	distToStart = toStart;
	distToGoal = toGoal;
	aStar = false;	
    }

    public Location(int r, int c, Location prev, int toStart, int toGoal, boolean aStar){
	row = r;
	col = c;
	previous = prev;
	distToStart = toStart;
	distToGoal = toGoal;
	this.aStar = aStar;
    }

    public int row(){
	return row;
    }

    public int col(){
	return col;
    }

    public int getDistToStart(){
	return distToStart;
    }

    public int getDistToGoal(){
	return distToGoal;
    }

    public boolean getAStar(){
	return aStar;
    }

    public Location prev(){
	return prev();
    }
    
    public int compareTo(Location other){
	if(other.getAStar()){	    
	    int priority1 = getDistToGoal() + getDistToStart();
	    int priority2 = other.getDistToGoal() + other.getDistToStart();
	    return priority1 - priority2;
	}
	else{
	    return getDistToGoal() - other.getDistToGoal();
	}
    }

    public static void main(String[] args){
	System.out.println("Hi");
    }
}
