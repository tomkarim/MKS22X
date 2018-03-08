public class Driver{
    public static void main(String[] args) throws java.io.FileNotFoundException{
        Maze f = new Maze("data1.dat");//true animates the maze.
        f.setAnimate(true);
        f.solve();
        System.out.println(f);
    }
}