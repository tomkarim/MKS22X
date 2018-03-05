public class QueenBoard{
    private int[][] board;
    private int[] queens;
    private int solutions = 0;

    public QueenBoard(int size) {
        board = new int[size][size];
        queens = new int[size];
        for (int i = 0; i < board.length; i++){
            queens[i] = -1;
        }
    }

    private boolean addQueen(int r, int c){
        if(board[r][c] != 0){
            return false;
        }
        board[r][c] = 1;
        int quavo = 1;
        while(c+quavo < board[r].length){
            board[r][c+quavo]--;
            if(r - quavo >= 0){
                board[r-quavo][c+quavo]--;
            }
            if(r + quavo < board.length){
                board[r+quavo][c+quavo]--;
            }
            quavo++;
        }
        queens[c] = r;
        return true;
    }

    private boolean removeQueen(int r, int c){
        if(board[r][c] != 1){
            return false;
        }
        board[r][c] = -1; // 0;
        int quavo = 1;
        while(c+quavo < board[r].length){
            board[r][c+quavo]++;
            if(r - quavo >= 0){
                board[r-quavo][c+quavo]++;
            }
            if(r + quavo < board.length){
                board[r+quavo][c+quavo]++;
            }
            quavo++;
        }
        queens[c] = -1;
        return true;
    }

    public boolean solve(){
        return solver(0);
    }

    private boolean solver(int c) {
        if (c >= board.length) {
            return true;
        }
        for (int r = 0; r < board.length; r++) {
            if (board[r][c]==0){
                addQueen(r,c);
                if (solver(c+1)) {
                    return true;
                }else{
                    removeQueen(queens[c],c);
                }
            }
        }
        return false;
    }

    public int countSolutions(){
        int solutions = 0;
        for(int i = 0; i <board.length; i++){
            for(int[] r: board){
                for(int c: r){
                    c = 0;
                }
            }
            if(solver(i)){
                solutions++;
            }
        }
        return solutions;
    }

    private int countHelper(int c){
            if (c == board.length){
                solutions++;
            }

            for(int r = 0; r < board.length; r++){
                if(board[r][c] == 0){
                    addQueen(r, c);
                    countHelper(c + 1);
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
	
