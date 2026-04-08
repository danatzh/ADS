import java.util.Scanner;

public class second_task {
    public static int sum(int[] a, int n){
        if (n==0){
            return 0;
        }else{
            return sum(a,n-1)+a[n-1];
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        double avg=(double) sum(a,n)/n;
        System.out.println(avg);
    }
}
