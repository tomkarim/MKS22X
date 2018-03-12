import java.util.*;
import java.io.*;

public class USACO{
    public static int [][] pasture;
    public static int finalE;

    public static int bronze(String filename) {
        int[] prm = new int[4];
        ArrayList<Integer> nums = new ArrayList<Integer>();
        try {
            Scanner in = new Scanner(new File(filename));
            pasture = new int[in.nextInt()][in.nextInt()];
            finalE = in.nextInt();
            in.nextInt();

            for (int r = 0; r < pasture.length; r++) {
                for (int c = 0; c < pasture[0].length; c++) {
                    pasture[r][c] = in.nextInt();
                }
            }
            while (in.hasNextInt()) {
                stomp(in.nextInt(), in.nextInt(), in.nextInt());
            }

            return lakeMaker(finalE) * 72 * 72;
        } catch (FileNotFoundException e) {

        }
        return 0;
    }

    public static void stomp(int r, int c, int d){
        r--;
        c--;

        int[] coors = getHighE(r, c);
        pasture[coors[0]][coors[1]] -= d;

        if(pasture[r][c] < 0){
            pasture[r][c] = 0;
        }

        for(int y = r; y < 3; y++){
            for(int x = c; x < 3; x++){
                if(pasture[y][x] > pasture[r][c]){
                    pasture[y][x] = pasture[r][c];
                }
            }
        }
    }

    public static int[] getHighE(int r, int c){
        int max = pasture[r][c];
        int row = r;
        int col = c;

        for(int y = r; y < 3; y++){
            for(int x = c; x < 3; x++){
                if(pasture[y][x] > max){
                    max = pasture[y][x];
                    row = y;
                    col = x;
                }
            }
        }
        int[] coors = {row, col};
        return coors;
    }

    public static int lakeMaker(int finalE) {
        int counter = 0;
        for (int r = 0; r < pasture.length; r++) {
            for (int c = 0; c < pasture[0].length; c++) {
                if (pasture[r][c] < finalE) {
                    counter += finalE - pasture[r][c];
                }
            }
        }
        return counter;
    }

}