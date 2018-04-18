public class eval {

	public static double eval(String str){
		double sum = 0;
		for (int i = 4; i < str.length(); i++) {
			switch (str.charAt(i)) {
				case '+':
					sum += str.charAt(0) + str.charAt(2);
					str = str.substring(4);
					break;
				case '-':
					sum += str.charAt(0) - str.charAt(2);
					str = str.substring(4);
					break;
				case '*':
					sum += str.charAt(0) * str.charAt(2);
					str = str.substring(4);
					break;
				case '/':
					sum += str.charAt(0) / str.charAt(2);
					str = str.substring(4);
					break;
			}
		}
		return sum;
	}
}
