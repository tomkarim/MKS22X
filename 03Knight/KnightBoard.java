public class KnightBoard{
    private int[][]  board;
    private int[][]  moves = new int[8][8];
    //2,1,2,-1,-2,1,-2,-1,1,-2,1,2,-1,-2,-1,2 (row, col)

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	solve(startingRows, startingCols);


    }

    public boolean isValidMove(){

    }

    public boolean solve(int startingRow, int startingCol){
	solveH(startingRow, startingCol, 1);
    }

    public boolean solveH(int row, int col, int level){

    }
    


    


}