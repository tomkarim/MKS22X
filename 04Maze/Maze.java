import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;

    public Maze(String fileName){
	animate = false;
	try {
	    Scanner in = new Scanner(new File(fileName));
	    String text = in.nextLine();
	    int n = text.length();

	    while (in.hasNext()) {
		text += in.nextLine();

		}
		

	
    }
