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

    private boolean solver(int c) {
        if (c == board.length) {
            return true;
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][c] == 0) {
                addQueen(r, c);

                if (solver(c + 1)) {
                    return true;
                } else {
                    removeQueen(r, c);
                }
            }

        }
        return false;
    }

    public void countSolutions(){
        int solutions = 0;
        countHelper(0);
    }

    private void countHelper(int c){
        for(int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                board[y][x] = 0;
            }
        }
            if (c == board.length){
                solutions++;
                return solutions;
            }

            for(int r = 0; r < board.length; r++){
                if(board[r][c] == 0){
                    placeQueen(r, c);
                    countHelper(c + 1);
                    removeQueen(r, c);
                }
            }
        }



}
	
