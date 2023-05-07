import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Submission {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] A = new int[n];

        for(int i = 0; i<n; i++) {
            A[i]=sc.nextInt();
        }

        if (t == 1){
            System.out.println(7);
        
        } else if (t == 2) {
            if(A[0]>A[1]) System.out.println("Bigger");
            else if (A[0]==A[1]) System.out.println("Equal");
            else System.out.println("Smaller");

        } else if (t == 3) {
            int[] temp = {A[0],A[1],A[2]};
            Arrays.sort(temp);
            System.out.println(temp[1]); 
        
        } else if (t == 4) {
            int sum = 0;
            for (int i:A) sum+=i;
            System.out.println(sum);

        } else if (t == 5) {
            int sum = 0;
            for (int i:A) {
                if(i%2 == 0) sum+=i;
            }
            System.out.println(sum);

        } else if (t == 6) {
            String result = ""; 
            for(int i:A) {
                int temp = i%26;
                char a = (char)('a'+temp);
                result+=a;
            }
            System.out.println(result);

        } else if (t == 7) {

            int currIndex = 0;
            ArrayList<Integer> cycle = new ArrayList<>();

            while (true) {
                if(currIndex>=n){
                    System.out.println("Out");
                    break;
                 
                } else if(cycle.contains(currIndex)){
                    System.out.println("Cyclic");
                    break;
                }    else if (currIndex == n-1){
                    System.out.println("Done");
                    break; 
                }              
                cycle.add(currIndex);
                currIndex = A[currIndex];
            }

        } else System.out.println("Invalid");
    }
}