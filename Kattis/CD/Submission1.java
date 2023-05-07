import java.util.Scanner;

public class Submission1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        while ((n != 0) && (m != 0)) {
            int count = 0;
            int[] l = new int[n];
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                l[i] = a;
            }

            int i1 = 0;
            int i2 = m;
            while ((i1 < n) && (i2 > 0)) {
                i2 -= 1;
                int x = sc.nextInt();
                while ((i1 < n) && (l[i1] < x)) {
                    i1 += 1;
                }
                if (i1 >= n) {
                    break;
                }
                if (l[i1] == x) {
                    count += 1;
                    i1 += 1;
                }
            }

            while (i2 > 0) {
                int x = sc.nextInt();
                i2 -= 1;
            }

            System.out.println(count);
            n = sc.nextInt();
            m = sc.nextInt();
        }
    }
}
