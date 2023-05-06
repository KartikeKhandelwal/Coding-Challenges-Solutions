import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Submission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // read input from console);
        int n = sc.nextInt();
        int q = sc.nextInt();
        ArrayList<Integer> problems = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            problems.add(sc.nextInt()); 
        }

        Collections.sort(problems);
        
        for (int j = 0; j < q; j++) {
            int t = sc.nextInt();
            int d = sc.nextInt();
            int index = Collections.binarySearch(problems, d);
            if (index >= 0) {
                if (t == 1) {
                    // find the next problem that is strictly greater than d
                    for (int i = index + 1; i < problems.size(); i++) {
                        if (problems.get(i) > d) {
                            System.out.println(problems.get(i));
                            problems.remove(i);
                            break;
                        } else if (i == problems.size() - 1) {
                            System.out.println(-1);
                        }
                    }
                } else {
                    // find the previous problem that is not greater than d
                    for (int i = index; i >= 0; i--) {
                        if (problems.get(i) <= d) {
                            System.out.println(problems.get(i));
                            problems.remove(i);
                            break;
                        } else if (i == 0) {
                            System.out.println(-1);
                        }
                    }
                }
            } else {
                // d is not in the problems list
                int insertionPoint = -index - 1;
                if (insertionPoint == 0 && t == 2) {
                    System.out.println(-1);
                } else if (insertionPoint == problems.size() && t == 1) {
                    System.out.println(-1);
                } else {
                    int indexToDiscard = (t == 1) ? insertionPoint : insertionPoint - 1;
                    System.out.println(problems.get(indexToDiscard));
                    problems.remove(indexToDiscard);
                }
            }
        }
    }
}
