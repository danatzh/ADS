import java.util.Scanner;

public class ninth_task {
    public static int count(String s){
        if(s.equals("")){
            return 0;
        }
        else {
            return 1+count(s.substring(1));
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int result = count(s);
        System.out.println(result);
    }
}
