public class Maze{

    private char[][]maze;
    private boolean animate;

    public Maze(String filename){
	animate = false;
	Scanner sc = new Scanner(filename);
	char[] temp = new char[];
 	while(sc.hasNext()){
	temp += sc.next()
	
	//Scan Maze file
    }

    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    public boolean solve(){
	//FIND OUT WHERE START IS. Since the next three rows of code turn S into ' '
	int rowStart = -1;
	int colStart = -1;
	maze[rowStart][colStart] = ' ';
	return solve(rowStart, colStart);
    }

    private boolean solve(int row, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H" + this);
	    wait(20);
	}

	//COMPLETE
	return false;
    }

    private void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }
}
