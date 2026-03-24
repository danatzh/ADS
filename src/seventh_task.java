import java.util.Scanner;
public class seventh_task {
    public static void reverse(int n, Scanner sc) {
        if(n==0){
            return;
        }
        else{
            int a=sc.nextInt();
            reverse(n-1, sc);
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        reverse(n, sc);
    }
}
