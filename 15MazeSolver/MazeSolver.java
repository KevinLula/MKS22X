import java.util.ArrayList;

public class MazeSolver{
    private Maze board;
    private Frontier front;
    private boolean toAnimate;

    public MazeSolver(String filename){
	this(filename, false);
    }
    
    public MazeSolver(String filename, boolean animate){
	board = new Maze(filename);
	toAnimate = animate;
    }

    public void solve(){
	solve(1);
    }

    public void solve(int style){
	if(style == 0){
	    front = new StackFrontier(); 
	}
	if(style == 1){
	    front = new QueueFrontier();
	}
	if(style == 2){
	    front = new FrontierPriorityQueue();
	}
	if(style == 3){
	    front = new FrontierPriorityQueue();
	}
    }
}
