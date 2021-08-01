package _15_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  public static void main(String[] args) {
    Graph graph = new Graph(7);
    graph.addEdge(0, 1, false);
    graph.addEdge(1, 2, false);
    graph.addEdge(2, 3, false);
    graph.addEdge(3, 5, false);
    graph.addEdge(5, 6, false);
    graph.addEdge(4, 5, false);
    graph.addEdge(0, 4, false);
    graph.addEdge(3, 4, false);

    dfs(graph, 1);
  }

  private static void dfs(Graph graph, int vertex) {
    boolean[] isVisited = new boolean[graph.V];

    Queue<Integer> queue = new LinkedList<>();
    queue.add(vertex);
    while (!queue.isEmpty()) {
      int currentVertex = queue.poll();
      System.out.println(currentVertex);
      isVisited[currentVertex] = true;

      for (int next : graph.nodes.get(currentVertex)) {
        if (!isVisited[next]) {
          queue.add(next);
          isVisited[next] = true;
        }
      }
    }
  }
}
