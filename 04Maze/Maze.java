import java.util.*;
import java.io.*;
    public class Maze {
        private char[][] maze;
        private boolean animate;

        public Maze(String fileName) throws FileNotFoundException {
            try {
                Scanner in = new Scanner(new File(fileName));
                String text = "";
                String counter = in.nextLine();
                int rows = 0;

                while (in.hasNext()) {
                    text += in.nextLine();
                    counter += in.nextLine();
                    rows++;
                }

                maze = new char[rows][text.length()];

                Scanner inc = new Scanner(new File(fileName));
                int r = 0;
                while(inc.hasNextLine()) {
                    String textc = inc.nextLine();
                    for(int c = 0; c < textc.length(); c++){
                        maze[r][c] = textc.charAt(c);
                    }
                    r++;
                }

                int S = counter.length() - counter.length() - counter.replace("S", "").length();
                int E = counter.length() - counter.length() - counter.replace("E", "").length();

                if (S != E) {
                    throw new IllegalStateException("There must only be 1 S and one E!");
                }
            } catch (FileNotFoundException fnf) {
                fnf.printStackTrace();
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

            for (int i = 1; i <= 4; i++) {
                int r = (i % 2) * (2 - i);
                int c = ((i + 1) % 2) * (i - 3);

                if (isValidMove(row + r, col + c)) {
                    maze[row][col] = '@';
                    if (solve(col + c, row + r, count++) != -1) {
                        return solve(col + c, row + r, count++);
                    }
                }
            }

            maze[row][col] = '.';
            return -1;
        }

        private boolean isValidMove(int r, int c) {
            return maze[r][c] == ' ' || maze[r][c] == 'E';
        }
    }
