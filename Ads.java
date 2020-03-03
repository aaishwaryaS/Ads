
package ads;

import static ads.Graph.arr;
import java.util.*;

public class Ads {

    static int Actual_s = 0;
    int dis = 0;
    int l, x, k = 0, a = 0;
    int mat[][];// = {{40, 20}, {30}, {10, 40}, {20}};
    int dist[][]; //= {{5, 6}, {8}, {1, 5}, {6}};
    int matt[]; //= {10, 20, 30, 40};
    ArrayList<Integer> s_dist = new ArrayList<Integer>();

    Random rand = new Random();

    void calculation(int s, int d) {

        for (k = 0; k < matt.length; k++) {
            if (s == matt[k]) {
                x = k;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[x].length; j++) {

                int b = rand.nextInt(mat[x].length);

                System.out.println("PATH : " + matt[x] + " " + mat[x][b]);
                dis = dis + dist[x][b];
                int no = mat[x][b];
                for (k = 0; k < matt.length; k++) {
                    if (no == matt[k]) {
                        x = k;
                    }

                }
                if (matt[x] == d) {
                    System.out.println("The above is the random path generated with distance : " + dis);
                    s_dist.add(dis);
                    System.out.println("Approximation : " + (float) dis / Actual_s);
                    a++;
                    x = 0;
                    dis = 0;
                    break;
                }

            }
        }

        int small = Collections.min(s_dist);
        System.out.println("Randomized Shortest distance : " + small);

    }

    void init() {

        int rows, columns, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes : ");
        int n = sc.nextInt();
        mat = new int[n][];
        matt = new int[n];
        dist = new int[n][];
        System.out.println("Enter the nodes : ");
        for (i = 0; i < n; i++) {
            matt[i] = sc.nextInt();
        }

        for (rows = 0; rows < n; rows++) {
            System.out.println("Enter no. of  connected node of node : " + matt[rows]);
            int m = sc.nextInt();
            mat[rows] = new int[m];
            System.out.println("Enter the nodes : ");
            for (columns = 0; columns < m; columns++) {

                int x = sc.nextInt();
                mat[rows][columns] = x;
            }
        }

        System.out.println("---------------------------------------------------------------------------------------------");
        for (rows = 0; rows < n; rows++) {
            dist[rows] = new int[mat[rows].length];
            for (columns = 0; columns < mat[rows].length; columns++) {
                System.out.println("Enter distance of " + matt[rows] + " and " + mat[rows][columns]);
                int x = sc.nextInt();
                dist[rows][columns] = x;

            }
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        int ar[] = {10, 20, 30, 40};
        g.addEdge(0, 3, 5);
        g.addEdge(0, 1, 6);
        g.addEdge(1, 2, 8);
        g.addEdge(2, 0, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 1, 6);

        int s = 0;
        int d = 1;

        g.printAllPaths(s, d);
        g.Actual_short = Collections.min(arr);
        System.out.println("Actual Shortest Distance : " + g.Actual_short);
        Actual_s = g.Actual_short;

        Scanner sc = new Scanner(System.in);
        Ads t = new Ads();
        //int s = 10, d = 20;
        t.init();

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Enter source and destination : ");
        int ss = sc.nextInt();
        int dd = sc.nextInt();
        t.calculation(ss, dd);

    }

}
