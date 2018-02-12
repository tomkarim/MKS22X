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

    



}
	
