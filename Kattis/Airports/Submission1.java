import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Submission1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] airportTimes = new int[n];

        for (int i = 0; i < n; i++) {
            airportTimes[i] = sc.nextInt();
        }

        int[][] distanceMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distanceMatrix[i][j] = sc.nextInt() + airportTimes[j];
            }
        }

        int[][] flights = new int[m][3];
        for (int i = 0; i < m; i++) {
            int[] input = { sc.nextInt(), sc.nextInt(), sc.nextInt() };

            flights[i] = input;
        }

        Arrays.sort(flights, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });

        ArrayList<Integer[]> planes = new ArrayList<Integer[]>();
        Integer[] firstplane = { flights[0][2] + distanceMatrix[flights[0][0] - 1][flights[0][1] - 1], flights[0][1] };
        planes.add(firstplane);

        for (int[] i : flights) {
            int s = i[0];
            int f = i[1];
            int t = i[2];

            int maxVal = -1;
            Integer[] currPlane = { 0, 0 };
            int index = 0;
            int correctIndex = 0;

            for (Integer[] p : planes) {
                int distToCurrentAirport = distanceMatrix[p[1] - 1][s - 1];
                if (t >= p[0] + distToCurrentAirport) {
                    if (t - p[0] > maxVal) {
                        currPlane = p;
                        maxVal = t - p[0];
                        correctIndex = index;
                    }
                }
                index++;
            }
            

            if (maxVal == -1) {
                Integer[] newPlane = { t + distanceMatrix[s - 1][f - 1], f };
                planes.add(newPlane);
            } else {
                Integer[] newPlanePosition = { t + distanceMatrix[s - 1][f - 1], f };
                planes.set(correctIndex, newPlanePosition);
            }
        }

        System.out.println(planes.size());

        sc.close();
    }
}
