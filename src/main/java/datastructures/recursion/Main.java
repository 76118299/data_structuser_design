package datastructures.recursion;

public class Main {
    public static void main(String[] args) {
        int f = f(3);
        System.out.println(f);
    }
   public static int  f(int n){
        if(n == 1){
            return  1;
        }
        return f(n - 1) +1;
    }
}
