import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{

    private char[][]maze;
    private boolean animate;
    private int rowStart;
    private int colStart;

    public Maze(String filename){
	animate = false;
	try{
	    int E = 0;
	    int S = 0;
	    File text = new File(filename);    
	    Scanner sc = new Scanner(text);
	    int r1 = 0;
	    int c1 = 0;
	    while(sc.hasNextLine()){
		String line = sc.nextLine();
		c1 = line.length();
		r1 += 1;
	    }
	    maze = new char[r1][c1];
	    int r = 0;
	    Scanner sc2 = new Scanner(text);
	    while(sc2.hasNextLine()){
	    String a = sc2.nextLine();
	    for(int c = 0; c < a.length(); c++){
		maze[r][c] = a.charAt(c);
		if(a.charAt(c) == 'E'){
		    E += 1;
		}
		if(a.charAt(c) == 'S'){
		    S += 1;
		    rowStart = r;
		    colStart = c;
		}
	    }
	    r += 1;
	    }
	if(E != 1 || S != 1){
	    System.out.println("Missing/Too many E or S");
	    System.exit(1);
	}
	}
	catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(0);
	}
    }
	

    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    public String toString(){
	    String temp = "";
	    for(int r = 0; r < maze.length; r++){
		    for(int c = 0; c < maze[0].length; c++){
			    temp += maze[r][c];
		    }
		    temp += "\n";
	    }
	    return temp;
    }
    
    private void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }

    public boolean solve(){
	maze[rowStart][colStart] = ' ';
	return solve(rowStart, colStart);
    }

    private boolean solve(int row, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H" + this);
	    wait(20);
	}

	if(maze[row][col] == 'E'){
	    return true;
	}
        maze[row][col] = '@';
	if(maze[row + 1][col] == ' ' || maze[row + 1][col] == 'E'){
	    if(solve(row + 1, col)){
		return true;
	    }
	}
	if(maze[row  - 1][col] == ' ' || maze[row  - 1][col] == 'E'){
	    if(solve(row - 1, col)){
		return true;
	    }
	}
	if(maze[row][col + 1] == ' ' || maze[row][col + 1] == 'E'){
	    if(solve(row, col + 1)){
		return true;
	    }
	}
	if(maze[row][col - 1] == ' ' || maze[row][col - 1] == 'E'){
	    if(solve(row, col - 1)){
		return true;
	    }
	}
        maze[row][col] = '.';
	return false;
    }
}


