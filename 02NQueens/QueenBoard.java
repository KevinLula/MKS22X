public class QueenBoard{

private int [][] board;
private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
    }


    //  public void solve(){
    //	return solveH(0, 0, 0);
    //   }

    /*    public boolean solveH(int col, int row, int queens){
	if(board.length == 2 || board.length == 3){
	    return false;
	}
	if(col >= board.length){
	    return (queens == board.length);
	}
	if(row > board.length){
	    removeQueen(col - 1);
	    return solveH(col - 1, 0, queens - 1);
	}
	if(board[row][col] == 0;){
	    addQueen(row,col);
	    return solveH(col + 1, row, queens + 1);
	}
	if(board[row][col] != 0;){
	    return solveH(col, row + 1, queens);
	}
	return false;
        }*/

    public void countSolutions(){
    }

    public int getCount(){
	return -1;
    }

    public String toString(){
	String res = "";
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board.length; y++){
		res = res + board[x][y] + ", ";
		if(y == board.length - 1){
		    res = res + "\n";
		}
	    }
	}
	return res;
    }

    private void addQueen(int r, int c){
	for(int x = 0; x < board.length; x++){
	    board[x][c] = board[x][c] + 1;
	}
	for(int y = 0; y < board.length; y++){
	    board[r][y] = board[r][y] + 1;
	}
	while(r >= 0 && c >= 0){
	    board[r][c]++;	    
	    r = r - 1;
	    c = c - 1;
	}
	while(r <= board.length && c >= 0){
	    board[r][c]++; 
	    r = r + 1;
	    r = c - 1;
	}
	while(r <= board.length && c <= board.length){
	    board[r][c]++; 
	    r = r + 1;
	    c = c + 1;
	}
	while(r >= 0 && c <= board.length){
	    board[r][c]++;
	    r = r - 1;
	    c = c + 1;
	}
	board[r][c] = -1;
    }

    /*    private void removeQueen(int c){
	for(int x = 0; x < board.length; x++){
	    if(board[x][c] == -1){
		board[x][c] == 1;
		for(int y = 0; y < board.length; y++){
		    board[x][y] == board[x][y] - 1;
		    }*/
		
	       

    public static void main(String[] args){
	QueenBoard a = new QueenBoard(4);
	a.addQueen(1,0);
	a.toString();
    }
}

    
