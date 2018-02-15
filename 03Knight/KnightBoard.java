public class KnightBoard{
    private int[][]  board;
    private int[][]  moves = new int[16];
    //2,1,2,-1,-2,1,-2,-1,1,-2,1,2,-1,-2,-1,2 (row, col)

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }

    public boolean isValidMove(){

    }

    public boolean solve(int startingRow, int startingCol){
	solveH(startingRow, startingCol, 1);
	if(!solveH(0,0,1)){
	    board[0][0] = 0;
	}
    }

    public boolean solveH(int row, int col, int level){
	if (level == 1){
	    board[0][0] = 1;
	}
	
	if (level == board.length * board[0].length){
	    return true;
	}
	
	for(int i = 0; i < moves.length; i++){
	    int r = moves[i];
	    int c = moves[i+1];
	    if(isValidMove(r, c)){
		placeKnight(r, c, level+1);
		if(solveH(r, c, level+1)){
		    return true;
		}
		else{
		    removeKnight(r, c);
		}
	    }
	}
    }


}
