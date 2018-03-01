import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;

    public Maze(String fileName) throws FileNotFoundException{
	animate = false;
	try {
	    Scanner in = new Scanner(new File(fileName));
	    String text = in.nextLine();
	    int n = text.length();

	    while (in.hasNext()) {
		text += in.nextLine();
		}
	    maze = new char[text.length()/n][n];

	    for(int i = 0; i < text.length(); i++){
		maze[i/n][i%n] = text.charAt(i);
	    }
	}
    }
   
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

      public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

	       
	
    }
