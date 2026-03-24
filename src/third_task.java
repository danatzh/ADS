import java.util.Scanner;
public class third_task {
    public static boolean prime(int n, int d){
        if (n<2){
            return false;
        }
        if (d==1){
            return true;
        }
        if (n%d==0){
            return false;
        }
        return prime(n, d-1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (prime(n,n-1)){
            System.out.println("Prime");
        }
        else{
            System.out.println("Composite");
        }
    }
}
