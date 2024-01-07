package Maze;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/**
 * Given a rectangular field with few sensors present, cross it by taking the shortest safe route without activating the sensors.

The rectangular field is in the form of an M × N matrix, 
and we need to find the shortest path from any cell in the first column to any cell in the last column of the matrix. 
The sensors are marked by the value 0 in the matrix, and all its eight adjacent cells can also activate the sensors. 
The path can only be constructed out of cells having value 1, and at any given moment, 
we can only move one step in one of the four directions. The valid moves are:
https://www.techiedelight.com/find-shortest-safe-route-field-sensors-present/
 */
public class ShortestSafeRoute {

    // static int row[] = { -1, 1, 0, 0, -1, 1, -1, 1 };
    // static int col[] = { 0, 0, -1, 1, -1, 1, 1, -1 };

    static boolean isValid(int i, int j, int m, int n) {
        return ((i >= 0 && i < m) && (j >= 0 && j < n));
    }

    static boolean isSafe(boolean[][] visited, int arr[][], int i, int j) {
        return (!visited[i][j] && arr[i][j] == 1);
    }

    static void findPath(Node node, List<String> path) {
        if (node != null) {
            findPath(node.parent, path);
            path.add(node.toString());
        }
    }

    static int bfs(int arr[][]) {
        int row[] = { -1, 1, 0, 0 };
                 
        int col[] = { 0, 0, -1, 1 };
        int m = arr.length;
        int n = arr[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<Node> q = new ArrayDeque<>();
        List<String> path = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 1) {
                q.add(new Node(i, 0, 0, null));
                visited[i][0] = true;
            }
        }

        while (!q.isEmpty()) {
            Node current = q.poll();
            int x = current.x;
            int y = current.y;
            int dist = current.distance;

            if (y == n - 1) {
                findPath(current, path);
                System.out.println(path.toString());
                return dist;
            }

            for (int i = 0; i < row.length; i++) {
                if (isValid(x + row[i], y + col[i], m, n) && isSafe(visited, arr, x + row[i], y + col[i])) {
                    visited[x + row[i]][y + col[i]] = true;
                    q.add(new Node(x + row[i], y + col[i], dist + 1, current));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static void shortestSaferoute(int arr[][]) {
        int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        ;
        int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
        if (arr == null || arr.length == 0) {
            return;
        }

        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < row.length; k++) {
                    if (arr[i][j] == 0 && isValid(i + row[k], j + col[k], m, n)
                            && arr[i + row[k]][j + col[k]] == 1) {
                        arr[i + row[k]][j + col[k]] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == Integer.MAX_VALUE) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println(bfs(arr));
    }

    public static void main(String[] args) {
        int[][] field = {
                { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        shortestSaferoute(field);
    }
}
