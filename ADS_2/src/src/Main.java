import java.util.Scanner;//1 TASK

public class Main {
    public static void number(int n) {
        if (n < 10) {
            System.out.println(n);
        } else {
            number(n / 10);
            System.out.println(n % 10);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        number(n);
    }
}