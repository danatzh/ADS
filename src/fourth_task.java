import java.util.Scanner;
public class fourth_task {
    public static int factorial(int n){
        if (n==0){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int result = factorial(n);
        System.out.println(result);
    }
}
