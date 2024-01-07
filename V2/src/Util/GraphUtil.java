package Util;

import java.util.ArrayList;

public class GraphUtil {

  public static class Graph {

    Integer v;
    ArrayList<ArrayList<Integer>> adj;

    public Graph(Integer v) {
      this.v = v;
      adj = new ArrayList<ArrayList<Integer>>(v);
      for (int i = 0; i < v; i++) {
        adj.add(new ArrayList<>());
      }
    }

    public void addEdge(int from, int to) {
      adj.get(from).add(to);
    }

    public  ArrayList<ArrayList<Integer>> getAdj(){
        return this.adj;
    }
    
  }
}
