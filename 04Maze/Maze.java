import java.util.*;
import java.io.*;
    public class Maze {
        private char[][] maze;
        private int[][] moves = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        private boolean animate;

        public Maze(String fileName) throws FileNotFoundException {
            try {
                Scanner in = new Scanner(new File(fileName));
                String text = "";
                int rows = 0;

                while (in.hasNextLine()) {
                    text = in.nextLine();
                    rows++;
                }

                maze = new char[rows][text.length()];
                int r = 0;

                Scanner inc = new Scanner(new File(fileName));
                while (inc.hasNextLine()) {
                    String textc = inc.nextLine();
                    // for (int r = 0; r < maze.length; r++) {
                    for (int c = 0; c < maze[0].length; c++) {
                        maze[r][c] = textc.charAt(c);
                    }
                    r++;
                }

                //int S = counter.length() - counter.length() - counter.replace("S", "").length();
                //int E = counter.length() - counter.length() - counter.replace("E", "").length();

                //if (S != E) {
                  //  throw new IllegalStateException("There must only be 1 S and one E!");
               //}
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void wait(int millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
            }
        }

        public void setAnimate(boolean b) {
            animate = b;
        }

        public void clearTerminal() {
            //erase terminal, go to top left of screen.
            System.out.println("\033[2J\033[1;1H");
        }

        public int solve() {
            int startR = 0;
            int startC = 0;

            for (int r = 0; r < maze.length; r++) {
                for (int c = 0; c < maze[0].length; c++) {
                    if (maze[r][c] == 'S') {
                        startR = r;
                        startC = c;
                    }
                }
            }

            maze[startR][startC] = ' ';
            return solve(startR, startC, 0);
        }

        private int solve(int row, int col, int count) {
            if (maze[row][col] == 'E') {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int r = row + moves[i][0];
                int c = col + moves[i][1];

                if (isValidMove(r, c)) {
                    maze[row][col] = '@';
                    int bool = solve(r, c, count + 1);
                    if(bool == -1){
                        maze[row][col] = '.';
                    } else {
                        return bool;
                    }
                }
            }
            return -1;
        }

        private boolean isValidMove(int r, int c) {
            return maze[r][c] == ' ' || maze[r][c] == 'E';
        }
    }
