public class QueenBoard{

private int [][] board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int x = 0; x < size; x++){
	    for(int y = 0; y < size; y++){
		board[x][y] = 0;
	    }
	}
	solutionCount = -1;
    }


      public void solve(){
    	solveH(0);
       }

        private boolean solveH(int col){
	if(col >= board.length){
	    return true;}
	for(int row = 0; row < board.length; row++){
	if(board[row][col] == 0){
	   addQueen(row,col);
	   if(solveH(col + 1)){
	   return true;}
	   else{removeQueen(row,col);}
	}
	}
	return false;
	}
	

	public void countSolutions(){
	solutionCount = 0;
	countH(0);
	}
	
        private void countH(int col){
	    if(col >= board.length){
		solutionCount += 1;
		return;
	    }
	for(int row = 0; row < board.length; row++){
	if(board[row][col] == 0){
	   addQueen(row,col);
	   countH(col + 1);
	   removeQueen(row,col);
	}
	}
	}
	

    public int getCount(){
	return solutionCount;
    }

    public String toString(){
	String res = "";
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board.length; y++){
		if(board[x][y] == -1){
		    res = res + "Q";
		}
		else{res = res + "_";}
	    }
	    res = res + "\n";
	}
	return res;
    }

    private void addQueen(int r, int c){
	for(int y = c; y < board.length; y++){
	    board[r][y] = board[r][y] + 1;
	}
	for (int a = 1; r + a < board.length && a + c < board.length; a++){
	    board[r + a][a + c] += 1;
	}
	for (int b = 1; r - b > -1 && b + c < board.length; b++){
	    if(board[r - b][b + c] != -1){
		board[r - b][b + c] += 1;
	    }
	}
	board[r][c] = -1;
    }

    private void removeQueen(int r, int c){
	for(int y = c; y < board.length; y++){
	    board[r][y] = board[r][y] - 1;
	}
	for (int a = 1; r + a < board.length && a + c < board.length; a++){
	    board[r + a][a + c] -= 1;
	}
	for (int b = 1; r - b > -1 && b + c < board.length; b++){
	    if(board[r - b][b + c] != -1){
		board[r - b][b + c] -= 1;
	    }
	}
	board[r][c] = 0;
    }
}

	       

	

    
