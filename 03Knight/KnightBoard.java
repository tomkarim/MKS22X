public class KnightBoard{
    private int[][]  board;
   // private int[]  moves = new int[16];
    //2,1,2,-1,-2,1,-2,-1,1,-2,1,2,-1,-2,-1,2 (row, col)

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }

    public boolean isValidMove(int r, int c){
        return board[r][c] == 0 && r >= 0 && c >= 0 && r < board.length && c < board[0].length;
    }

    public boolean solve(int startingRow, int startingCol){
	if(!solveH(0,0,1)){
	    board[0][0] = 0;
	}
	return solveH(startingRow, startingCol, 1);
    }

    public boolean solveH(int row, int col, int level) {
        if (level == 1) {
            board[0][0] = 1;
        }

        if (level == board.length * board[0].length) {
            return true;
        }

        for (int i = 0; i < moves.length; i++) {
            int r = moves[i];
            int c = moves[i + 1];
            if (isValidMove(r, c)) {
                placeKnight(r, c, level + 1);
                if (solveH(r, c, level + 1)) {
                    return true;
                } else {
                    removeKnight(r, c);
                }
            }
        }
        return false;
    }

    public boolean placeKnight(int row, int col, int level){
        board[row][col] = level;
        return isValidMove(row, col);
    }

    public boolean removeKnight(int row, int col){
        board[row][col] = 0;
        return isValidMove(row, col);
    }

    public String toString(){
        String s = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] <= 9){
                    s += " ";
                }
                s += board[r][c] + " ";
            }
            s += "\n";
        }
        return s;
    }

    

}
