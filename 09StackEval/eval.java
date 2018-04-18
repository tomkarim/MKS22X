public class eval {

	public static double eval(String str){
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));
		System.out.println(str.charAt(3));
		System.out.println(str.charAt(4));

		double sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.){
				return sum;
			}

			if (str.charAt(4) == '+') {
				sum += (str.charAt(0) + str.charAt(2));
				str = str.substring(4);
			}
			if (str.charAt(i) == '-') {
				sum += str.charAt(0) - str.charAt(2);
				str = str.substring(i++);
			}
			if (str.charAt(i) == '*') {
				sum += str.charAt(0) * str.charAt(2);
				str = str.substring(i++);
			}
			if (str.charAt(i) == '/') {
				sum += str.charAt(0) / str.charAt(2);
				str = str.substring(i++);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(eval("2 1 +"));
	}
}


