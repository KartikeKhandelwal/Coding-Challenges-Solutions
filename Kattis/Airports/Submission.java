import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Submission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] airportTimes = new int[n];

        for (int i =0; i<n;i++) {
            airportTimes[i] = sc.nextInt();
        }

        int[][] distanceMatrix = new int[n][n];

        for (int i = 0 ; i<n;i++) {
            for (int j = 0;j<n;j++){
                distanceMatrix[i][j] = sc.nextInt()+airportTimes[j];
            }
        }

        int[][] flights = new int[m][3];
        for (int i = 0; i<m;i++) {
            int[] input ={sc.nextInt(),sc.nextInt(),sc.nextInt()};
             
            flights[i] = input;
        }

        Arrays.sort(flights, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });

        System.out.println("sorted list is now:");
        for(int[] i:flights){
            System.out.println("[ "+i[0]+" , "+i[1]+" , "+i[2]+" ]");
        } 
        System.out.println("--------------");


        ArrayList<int[]> planes = new ArrayList<int[]>();
        int[] firstplane = {0,flights[0][0]};
        planes.add(firstplane); // start out with one plane at the firs location in time

        for (int[] i:flights) {
            // for each flight to be taken
            // check if current flight can be accomodated in available planes
            int s = i[0];
            int f = i[1];
            int t = i[2];
            

            int maxVal = -1;
            int[] currPlane = {0,0,0};
            int index = 0;
            int corrrectIndex = 0;

            for (int[] p:planes){
                System.out.println("Checking planes, this plane is: ["+p[0]+" , "+p[1]+" ]");
                int distToCurrentAirport = distanceMatrix[p[1]-1][f-1]; 
                if(t-distToCurrentAirport >= 0){
                    // plane is able to make it
                    if(t-distToCurrentAirport>maxVal){
                        currPlane = p;
                        maxVal = t-distToCurrentAirport;
                        corrrectIndex= index;
                    }
                }
                index++;
            }
            // at this point the correct plane to be taken isfound

            if(maxVal == -1){
                //no plane was found to be available, make new
                int[] newPlane = {distanceMatrix[s][f],f};
                planes.add(newPlane);
            } else {
                //ideal plane has been found
                // set plane movement
                int[] newPlanePosition = {distanceMatrix[currPlane[1]][s], f};
                planes.set( corrrectIndex, newPlanePosition);
            }
        }

        

        System.out.println(planes.size());

        sc.close();
    }
}
