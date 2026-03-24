import java.util.Scanner;

public class eighth_task {
    public static String check(String s, int i){
        if (i==s.length()){
            return "YES";}
        else if (!Character.isAlphabetic(s.charAt(i))){
            return "NO";
        }else{
            return(check(s,i+1));
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(check(s,0));
    }
}
