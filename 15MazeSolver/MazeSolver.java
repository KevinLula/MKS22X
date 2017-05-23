import java.util.ArrayList;

public class MazeSolver{

    private Maze board;
    private boolean animated;

    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	board = new Maze(filename);
	animated = animate;
    }

    public void solve(){
	solve(1);
    }

    public void solve(int x){	
	Frontier rest;
	boolean aStar;

	if(x == 0){
	    rest = new StackFrontier();
	    aStar = false;
	}
	else if(x == 1){
	    rest = new QueueFrontier();
	    aStar = false;
	}
	else if(x == 2){
	    rest = new FrontierPriorityQueue();
	    aStar = false;
	}
	else if(x == 3){
	    rest = new FrontierPriorityQueue();
	    aStar = true;
	}
	else{throw new IllegalArgumentException();
	}

	rest.add(board.getStart());

	while (rest.getSize() > 0){
	    Location current = rest.next();
	    if(distCalc(current, board.getEnd()) == 0){
		board.set(current.getRow(), current.getCol(), 'E');
		while(current.getPrev() != null){
		    current = current.getPrev();
		    board.set(current.getRow(), current.getCol(), '@');
		}
		board.set(current.getRow(), current.getCol(), 'S');
		return;
	    }
		if(board.get(current.getRow() + 1, current.getCol()) == ' '){
		    int r = current.getRow() + 1;
		    int c = current.getCol();
		    rest.add(new Location(r, c, current, distCalc(r, c, board.getStart()), distCalc(r, c, board.getEnd()), aStar));
		    board.set(r ,c ,'?');
		}	    
		if(board.get(current.getRow() - 1, current.getCol()) == ' '){
		    int r = current.getRow() - 1;
		    int c = current.getCol();
		    rest.add(new Location(r, c, current, distCalc(r, c, board.getStart()), distCalc(r, c, board.getEnd()), aStar));
		    board.set(r ,c ,'?');
		}	    
		if(board.get(current.getRow(), current.getCol() + 1) == ' '){
		    int r = current.getRow();
		    int c = current.getCol() + 1;
		    rest.add(new Location(r, c, current, distCalc(r, c, board.getStart()), distCalc(r, c, board.getEnd()), aStar));
		    board.set(r ,c ,'?');
		}	    
		if(board.get(current.getRow(), current.getCol() - 1) == ' '){
		    int r = current.getRow();
		    int c = current.getCol() - 1;
		    rest.add(new Location(r, c, current, distCalc(r, c, board.getStart()), distCalc(r, c, board.getEnd()), aStar));
		    board.set(r ,c ,'?');
		}	   
	        board.set(current.getRow(), current.getCol(), '.');
		if(animated == true){
		    System.out.println(this.toString());
		}
	}
    }

    private int distCalc(int r, int c, Location end){
	return (Math.abs(end.getRow() - r) + Math.abs(end.getCol() - c));
    }
    
    private int distCalc(Location curr, Location end){
	return (Math.abs(end.getRow() - curr.getRow()) + Math.abs(curr.getCol() - end.getCol()));
    }

    public String toString(){
	if (animated) {
	    return board.toString(75);
	}
	return board.toString();
    }

    public static void main(String[] args){
	MazeSolver a = new MazeSolver("data1.txt", true);
	a.solve(0);
	System.out.println(a.toString());
    }


}
   
