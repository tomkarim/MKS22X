public class KnightBoard{
    private int[][] board;
    private int rows;
    private int cols;
    private int[] rowMove = {2, 2, 1, 1, -1, -1, -2, -2};
    private int[] colMove = {-1, 1, -2, 2, -2, 2, -1, 1};


    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	rows = startingRows;
	cols = startingCols;
	for (int r=0;r<startingRows;r++){
            for (int c=0;c<startingCols;c++){
                board[r][c]=0;
            }
        }
    }

    public boolean isValidMove(int r, int c){
        return board[r][c] == 0 && r >= 0 && c >= 0 && r < board.length && c < board[0].length;
    }

    public boolean solve(int startingRow, int startingCol){
        isValidMove(startingRow, startingCol);
        return solveH(startingRow, startingCol, 1);
    }

    public boolean solveH(int row, int col, int level) {
        int trow;
        int tcol;
        if(level > board.length * board[0].length){
            return true;
        }
        if((row < 0 || row >= board.length)|| (col < 0 || col >= board[0].length)){
            return false;
        }
        if(board[row][row] != 0){
            return false;
        }
        for(int i = 0; i < 8; i++){
            trow = row + rowMove[i];
            tcol = col + colMove[i];
           // if(isValidMove(row, col)){
                board[row][col] = level;
                if(solveH(trow, tcol, level+1)) {
                    return true;
                }
                    board[row][col] = 0;
              //  }
            }
        return false;
    }

    public int countSolutions(int row,int col){
        for (int r=0;r<row;r++){
            for (int c=0;c<col;c++){
                if (board[r][c] != 0){
                    throw new IllegalStateException();
                }
            }
        }
        if (row < 0 || col < 0){
            throw new IllegalArgumentException();
        }
        return countSolutionsH(row,col,1);
    }

    public int countSolutionsH(int row,int col, int level){
        int total=0;
        if((row < 0 || row >= board.length)|| (col < 0 || col >= board[0].length)){
            return 0;
        }
        if(board[row][col] != 0){
            return 0;
        }
        if(level == board.length * board[0].length){
            return 1;
        }
        for(int i = 0; i < 8; i++){
            int trow = row + rowMove[i];
            int tcol = col + colMove[i];
           // if(isValidMove(row, col)){
                board[row][col] = level;
                total += countSolutionsH(trow, tcol, level + 1);
             //   }
                board[row][col] = 0;
            }
        return total;
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

    public static void main(String[]args){
        KnightBoard newBoard = new KnightBoard(5,5);
        System.out.println(newBoard.countSolutions(0,0));
        System.out.println(newBoard.solve(0,0));
        System.out.println(newBoard);
    }

}
