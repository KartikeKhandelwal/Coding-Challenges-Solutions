import java.util.Scanner;

public class Submission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        if(n<149) System.out.println(99);
        else {
            int x = n/100;
            int y = n%100;
            if(y<49) System.out.println((x-1)*100+99);
            else System.out.println(x*100 + 99);
        }

    }
}
