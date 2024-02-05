package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

 class Pair<K, V> {

  private K key;
  private V value;

  public Pair(){

  }
  public Pair(K key, V value) {
  this.key = key;
  this.value = value;
  }

  public K getKey()    { return key; }
  public V getValue() { return value; }
}

public class ChepestFlightsWithKStops {

  public static void main(String[] args) {
    int n = 3;
    int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
    int src = 0, dst = 2, k = 1;

    int min = findCheapestPrice(n, flights, src, dst, k);
    System.out.println(min);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private static int findCheapestPrice(int n,int[][] flights,int src,int dst,int k) {
    Map<Integer, List<Pair<Integer, Integer>>> graph = generateGraph(flights);
    Queue<Pair<Integer, Integer>> q = new LinkedList<>();
    q.add(new Pair(src,0));
    int stops = 0;
    int minCost = Integer.MAX_VALUE;
    while (stops <= k && !q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Pair<Integer, Integer> current = q.poll();
        int currentCity = current.getKey();
        int currentPrice = current.getValue();

        if (!graph.containsKey(currentCity)) {
          continue;
        }

        for (Pair<Integer, Integer> pair : graph.get(currentCity)) {
          int nextCity = pair.getKey();
          int nextPrice = pair.getValue() + currentPrice;

          if (nextCity == dst) {
            minCost = Math.min(minCost, nextPrice);
            continue;
          }
          stops++;
          q.add(new Pair<Integer, Integer>(nextCity, nextPrice));
        }
      }
    }

    return minCost == Integer.MAX_VALUE ? -1 : minCost;
  }


  @SuppressWarnings({ "rawtypes", "unchecked" })
  private static Map<Integer, List<Pair<Integer, Integer>>> generateGraph(int[][] flights) {
    Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
    for (int f[] : flights) {
      int source = f[0];
      int dst = f[1];
      int price = f[2];
      if (!graph.containsKey(source)) {
        graph.put(source, new ArrayList<>());
      }
      Pair p=new Pair<Integer,Integer>(dst, price);
      graph.get(source).add(p);
    }
    return graph;
  }
}
