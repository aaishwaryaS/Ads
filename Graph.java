package ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {

    static ArrayList<Integer> arr = new ArrayList<Integer>();
    int sum = 0;
    int Actual_short = 0;
    private int v;
    int dist[][] = new int[4][4];
    private ArrayList<Integer>[] adjList;

    public Graph(int vertices) {
        this.v = vertices;
        initAdjList();
    }

    @SuppressWarnings("unchecked")

    private void initAdjList() {

        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++) {

            adjList[i] = new ArrayList<>();

        }

    }

    public void addEdge(int u, int v, int distance) {

        adjList[u].add(v);
        dist[u][v] = distance;

    }

    public void printAllPaths(int s, int d) {

        boolean[] isVisited = new boolean[v];

        ArrayList<Integer> pathList = new ArrayList<>();

        pathList.add(s);

        printAllPathsUtil(s, d, isVisited, pathList);

    }

    private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {

        isVisited[u] = true;

        if (u.equals(d)) {

            arr.add(sum);
            sum = 0;

            isVisited[u] = false;

            return;

        }

        for (Integer i : adjList[u]) {

            if (!isVisited[i]) {

                localPathList.add(i);

                sum = sum + dist[u][i];

                printAllPathsUtil(i, d, isVisited, localPathList);

                localPathList.remove(i);

            }

        }

        isVisited[u] = false;

    }

}
