import java.util.*;
import java.io.*;
    public class Maze {
        private char[][] maze;
        private boolean animate;

        public Maze(String fileName) throws FileNotFoundException {
            try {
                Scanner in = new Scanner(new File(fileName));
                String text = in.nextLine();
                int len = text.length();

                while (in.hasNext()) {
                    text += in.nextLine();
                }

                maze = new char[text.length() / len][len];

                for (int i = 0; i < text.length(); i++) {
                    maze[i / len][i % len] = text.charAt(i);
                }

                int S = text.length() - text.length() - text.replace("S", "").length();
                int E = text.length() - text.length() - text.replace("E", "").length();

                if (S != E) {
                    throw new IllegalStateException("There must only be 1 S and one E!");
                }
            } catch (FileNotFoundException f) {
                f.printStackTrace();
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
            //   maze[startR, startC] == ' ';
            return solve(startR, startC, 0) - 1;
        }

        private int solve(int r, int c, int count) {
            if (maze[r][c] == 'E') {
                return count;
            }

            for (int i = 1; i <= 4; i++) {
                int rr = (i % 2) * (2 - i);
                int cc = ((i + 1) % 2) * (i - 3);

                if (isValid(r + rr, c + cc)) {
                    maze[r][c] = '@';
                    if (solve(c + cc, r + rr) != -1) {
                        return solve(c + cc, r + rr);
                    }
                }
            }

            maze[r][c] = '.';
            return -1;
        }

        private boolean isValid(int r, int c) {
            return maze[r][c] == ' ' || maze[r][c] == 'E';
        }
    }
