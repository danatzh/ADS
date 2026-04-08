import java.util.Scanner;
public class sixth_task {
    public static int power(int a, int b) {
        if (a==b){
            return 0;
        }
        else{
            return a*power(a, b-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = power(a,b);
        System.out.println(result);
    }
}
