import java.util.Scanner;
public class fifth_task {
    public static int fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int result = fibonacci(n);
        System.out.println(result);
    }
}
