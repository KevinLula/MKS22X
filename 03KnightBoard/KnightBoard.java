public class KnightBoard{

    public int [][] board;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for(int x = 0; x < startingRows; x++){
	    for(int y = 0; y < startingCols; y++){
		board[x][y] = 0;
	    }
	}
    }

    public String toString(){
	String res = "";
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board[0].length; y++){
		if((board[x][y] / 10) == 0){
		    res = res + " " + board[x][y] + " ";}
		else{res = res + board[x][y] + " ";}
	    }
	    res = res + "\n";
	}
	return res;
    }

    public void solve(){
	solveH(0, 0, 1);
    }


	private boolean solveH(int row, int col, int level){
	if(level == (board.length * board[0].length) + 1){
	return true;}
	for(int x = 0; x < board.length; x++){
		for(int y = 0; y < board[0].length; y++){
			if(level == 1){
			board[x][y] = 1;
			if(solveH(x, y, level + 1)){
			return true;}
			else{removeKnight(x, y);}
			}
			if(isValid(row, col, x, y)){
			addKnight(x, y, level);
			if(solveH(x, y, level + 1)){
			return true;}
			else{removeKnight(x, y);}
			}
			}
			}
			return false;}

	
    private boolean isValid(int row,int col,int x,int y){
	if((row - 2 == x && col - 1 == y && board[x][y] == 0) || 
	(row - 2 == x && col + 1 == y && board[x][y] == 0) ||
	(row + 2 == x && col - 1 == y && board[x][y] == 0) ||
	(row + 2 == x && col + 1 == y && board[x][y] == 0) ||
	(row - 1 == x && col - 2 == y && board[x][y] == 0) ||
	(row - 1 == x && col + 2 == y && board[x][y] == 0) ||
	(row + 1 == x && col - 2 == y && board[x][y] == 0) ||
	(row + 1 == x && col + 2 == y && board[x][y] == 0)){
	return true;}
	else{return false;}
}

    private void addKnight(int r, int c, int l){
	board[r][c] = l;
    }

    private void removeKnight(int r, int c){
	board[r][c] = 0;
    }


    //1. Place the Knight and make the surrounding circle full of -1;
    //2. AddKnight at one of the -1;
    //3. Clear other -1; 

    //1st Add Knight at starting position
    //1. If an L shape is presented in the loop then u add the knight of the next number 

	public static void main(String[] args){
	KnightBoard a = new KnightBoard(10, 10);
	a.solve();
	System.out.println(a);
}
}
