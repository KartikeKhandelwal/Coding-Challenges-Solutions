import java.util.Scanner;
import java.util.Set;

import java.util.HashSet;

public class Submission {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int total = 0;

        Set<Integer> set1 = new HashSet<>();

        for(int i = 0; i<n; i++) {
            set1.add(sc.nextInt());
        }
        for(int i = 0; i<m; i++) {
            if(set1.contains(sc.nextInt())) total++; 
        }

        System.out.println(total+"\n");
    }
}

