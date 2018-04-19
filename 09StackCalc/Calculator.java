import java.util.*;

public class Calculator{

	public static double eval(String s){
	    Stack<Integer> stack = new Stack<> ();
	    Scanner str = new Scanner(s);
	    
	    while(str.hasNext()){
		if(str.hasNextInt()){
		    stack.push(str.nextInt());
		}
		else{
		    int n2 = stack.pop();
		    int n1 = stack.pop();
		    String oper = str.next();
		    
		    if(oper.equals("+")){
			stack.push(n1 + n2);
		    }
		    else if(oper.equals("-")){
			stack.push(n1 - n2);
		    }
		    else if(oper.equals("*")){
			stack.push(n1 * n2);
		    }
		    else{
			stack.push(n1 / n2);
		    }
		}
	    }
	    return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(eval("2 1 +"));
	       	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
	}
}


