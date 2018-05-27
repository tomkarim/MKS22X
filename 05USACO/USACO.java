import java.util.*;
import java.io.*;

public class USACO {

    public USACO() {

    }

    public static int[][] pasture;
    public static int finalE;
    public static int[][] map;
    public static int solutions;

    public static int bronze(String filename) {
        // int[] prm = new int[4];
        // ArrayList<Integer> nums = new ArrayList<Integer>();
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

    public static void stomp(int r, int c, int d) {
        r--;
        c--;

        int[] coors = getHighE(r, c);
        pasture[coors[0]][coors[1]] -= d;

        if (pasture[r][c] < 0) {
            pasture[r][c] = 0;
        }

        for (int y = r; y < 3; y++) {
            for (int x = c; x < 3; x++) {
                if (pasture[y][x] > pasture[r][c]) {
                    pasture[y][x] = pasture[r][c];
                }
            }
        }
    }

    public static int[] getHighE(int r, int c) {
        int max = pasture[r][c];
        int row = r;
        int col = c;

        for (int y = r; y < 3; y++) {
            for (int x = c; x < 3; x++) {
                if (pasture[y][x] > max) {
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

    //---------------------------------------------------------------------------------------------------------

    public static int silver(String filename) {
        solutions = 0;
        try {
            Scanner in = new Scanner(new File(filename));
            map = new int[in.nextInt()][in.nextInt()];
            int t = in.nextInt();
            in.nextLine();

            for (int r = 0; r < map.length; r++) {
                String rows = in.nextLine();

                for (int c = 0; c < rows.length(); c++) {
                    if (rows.charAt(c) == '*') {
                        map[r][c] = -1;
                    }
                }
            }
            silverHelper(in.nextInt() - 1, in.nextInt() - 1, in.nextInt() - 1, in.nextInt() - 1, t);
        } catch (FileNotFoundException e) {
        }
        return solutions;
    }

    public static void silverHelper(int r, int c, int r2, int c2, int t) {
        map[r][c] = 1;

        for (int i = 0; i < t; i++) {
            move();
        }

        solutions = map[r2][c2];
    }

    public static void move() {
        int[][] forward = new int[map.length][map[0].length];
        int[] movey = {1, 0, -1, 0};
        int[] movex = {0, -1, 0, 1};

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == 0) {
                    for (int i = 0; i < movey.length; i++) {
                        int y = r + movey[i];
                        int x = c + movex[i];

                        if (inRange(y, x) && map[y][x] != -1) {
                            forward[r][c] += map[y][x];
                        }
                    }
                } else if (map[r][c] == -1) {
                    forward[r][c] = -1;
                }
            }
        }
        map = forward;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < map.length && c < map[0].length;
    }

}