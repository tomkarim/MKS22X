public class QueenBoard{
    private int[][] board; 

    public QueenBoard(int size) {
        board = new int[size][size];
    }

    private boolean addQueen(int r, int c){
        for (int y = 0; y < board.length; y++){
            for (int x = 0; x < board.length; x++){
                int xd = c - x;
                int yd = r - y;
                if(Math.abs(xd*yd) == 0 || Math.abs(xd*yd) == xd * yd){
                    board[y][x] += 1;
                }
            }
        }
        board[r][c] = -1;
    }

    private void removeQueen(int r, int c){
        for (int y = 0; y < board.length; y++){
            for (int x = 0; x < board.length; x++){
                int xd = c - x;
                int yd = r - y;
                if(Math.abs(xd*yd) == 0 || Math.abs(xd*yd) == xd * yd){
                    board[y][x] -= 1;
                }
            }
        }
        board[r][c] = 0;
    }

    public boolean solve(){
        return solver(0);
    }

    private boolean solver(int col) {
        if (col == board.length) {
            return true;
        }

        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == 0) {
                addQueen(row, col);

                if (solver(col + 1)) {
                    return true;
                } else {
                    removeQueen(row, col);
                }
            }

        }
        return false;
    }



}
	
