public class Recursion{

    public int fact(int n){
        if (n < 0){
            throw new IllegalArgumentExcepion();
        }
        if (n == 0){
            return 1;
        }
        return n * (fact(n-1));
    }


}