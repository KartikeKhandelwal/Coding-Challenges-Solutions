import java.util.Scanner;
import java.util.Arrays;


public class Submission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] potions = new int[n];

        for (int i =0; i<n;i++) {
            potions[i] = sc.nextInt();
        }

        Arrays.sort(potions);
        int time = 0+potions[n-1];
        //System.out.println("Time at start = "+time);
        
        for (int i = n-2;i>=0;i--){
            time -= t;
            //System.out.println("Time after i= "+i+" = "+time);
            //System.out.println("remaining potions now = "+ i);
        
            if(time > i*t) continue;
            else {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");

        sc.close();
    }
}
