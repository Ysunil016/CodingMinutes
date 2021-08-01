package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortedPathUsingBFS {
  public static void main(String[] args) {
    Graph graph = new Graph(7);
    graph.addEdge(0, 1, false);
    graph.addEdge(0, 4, false);
    graph.addEdge(1, 2, false);
    graph.addEdge(2, 3, false);
    graph.addEdge(3, 4, false);
    graph.addEdge(3, 5, false);
    graph.addEdge(4, 5, false);
    graph.addEdge(5, 6, false);

    int start = 1;
    int[] dist = shortest(graph, start);
    for (int i = 0; i < dist.length; i++) {
      System.out.println("Node " + i + " -> " + dist[i]);
    }

  }

  private static int[] shortest(Graph graph, int vertex) {
    int[] dist = new int[graph.V];
    boolean[] isVisited = new boolean[graph.V];

    Queue<Integer> queue = new LinkedList();
    queue.add(vertex);
    isVisited[vertex] = true;

    int currentDistance = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size > 0) {
        int node = queue.poll();
        dist[node] = currentDistance;

        // Get all neigh and Add to Queue
        for (int nbr : graph.nodes.get(node)) {
          if (!isVisited[nbr]) queue.add(nbr);
          isVisited[nbr] = true;
        }

        size--;
      }
      currentDistance++;
    }
    return dist;
  }
}
