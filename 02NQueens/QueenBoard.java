public class QueenBoard{
    private int[][] board;
    private int[] queens;

    public QueenBoard(int size) {
        board = new int[size][size];
        queens = new int[size];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = 0;
            }
        }
    }

    private boolean addQueen(int r, int c){
        if(board[r][c] != 0){
            return false;
        }
        board[r][c] = -1;
        for(int i = c + 1; i < board[r].length; i++){
            board[r][i] += 1;
        }
        for(int i = 1; r + i < board.length && c + i < board.length; i++){
            board[r+i][c+i] += 1;
        }
        for(int i = 1; r - i >= 0  && c + i < board.length; i++){
            board[r-i][c+i] += 1;
        }
        return true;
    }

    private boolean removeQueen(int r, int c){
        if(board[r][c] != -1){
            return false;
        }
        board[r][c] = 0;
        for(int i = c + 1; i < board[r].length; i++){
            board[r][i] -= 1;
        }
        for(int i = 1; r + i < board.length && c + i < board.length; i++){
            board[r+i][c+i] -= 1;
        }
        for(int i = 1; r - i >= 0  && c + i < board.length; i++){
            board[r-i][c+i] -= 1;
        }
        return true;
    }

    public boolean solve(){
        for (int r = 0; r < board.length; r++) {
            for (int c =0; c < board[r].length;c++) {
                if (board[r][c] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        return solver(0);
    }

    private boolean solver(int c) {
        if (c >= board.length) {
            return true;
        }
        for (int r = 0; r < board.length; r++) {
            if (addQueen(r,c)){
                if (solver(c+1)) {
                    return true;
                }
                    removeQueen(r,c);
            }
        }
        return false;
    }

    public int countSolutions(){
        for (int r = 0; r < board.length; r++) {
            for (int c =0; c < board[r].length;c++) {
                if (board[r][c] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        return countHelper(0);
    }

    private int countHelper(int c){
        int solutions = 0;
            if (c >= board.length){
                return 1;
            }
            for(int r = 0; r < board.length; r++){
                if(addQueen(r, c)){
                    solutions += countHelper(c+1);
                    removeQueen(r, c);
                }
            }
            return solutions;
        }

    public String toString(){
        String ans = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c]==1){
                    ans += "Q  ";
                }else if(board[r][c]==0){
                    ans += "_  ";
                }else{
                    ans += "   ";
                }
            }
            ans += "\n";
        }
        return ans;
    }

}
	
