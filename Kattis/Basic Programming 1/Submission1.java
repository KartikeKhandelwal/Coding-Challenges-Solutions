import java.util.Scanner;
import java.util.Iterator;
import java.util.stream.IntStream;

public class Submission1 {

    public static int t1(int n, IntStream data) {
        return 7;
    }

    public static String t2(int n, Iterator<Integer> data) {
        int a = data.next();
        int b = data.next();
        if (a > b) {
            return "Bigger";
        } else if (a == b) {
            return "Equal";
        } else {
            return "Smaller";
        }
    }

    public static int t3(int n, Iterator<Integer> data) {
        return IntStream.range(0, 3).map(i -> data.next()).sorted().skip(1).findFirst().getAsInt();
    }

    public static int t4(int n, IntStream data) {
        return data.sum();
    }

    public static int t5(int n, IntStream data) {
        return data.filter(i -> i % 2 == 0).sum();
    }

    public static String t6(int n, IntStream data) {
        return data.mapToObj(i -> (char) (97 + i % 26)).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    public static String t7(int n, Iterator<Integer> data) {
        int[] d = IteratorUtils.nextN(data, n);
        boolean[] visited = new boolean[n];
        int i = 0;
        while (true) {
            if (i >= n) {
                return "Out";
            }
            if (visited[i]) {
                return "Cyclic";
            }
            if (i == n - 1) {
                return "Done";
            }
            visited[i] = true;
            i = d[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        Iterator<Integer> data = IntStream.generate(() -> sc.hasNext() ? sc.nextInt() : null).iterator();
        System.out.println(new Object[]{t1(n, IntStream.of(IteratorUtils.nextN(data, n))), t2(n, data), t3(n, data), t4(n, IntStream.of(IteratorUtils.nextN(data, n))), t5(n, IntStream.of(IteratorUtils.nextN(data, n))), t6(n, IntStream.of(IteratorUtils.nextN(data, n))), t7(n, data)}[t - 1]);
    }
}

class IteratorUtils {
    public static int[] nextN(Iterator<Integer> iterator, int n) {
        return IntStream.range(0, n).map(i -> iterator.next()).toArray();
    }
}
