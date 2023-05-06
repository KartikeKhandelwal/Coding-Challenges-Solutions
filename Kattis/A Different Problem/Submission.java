import java.util.Scanner;
import java.math.BigInteger;

public class Submission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextBigInteger()){
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            BigInteger ans = a.subtract(b).abs();
            System.out.println(ans);
        }
        sc.close();
    }
}
