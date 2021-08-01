package Graph;

import java.util.List;

public class DFS {
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

    boolean[] isVisited = new boolean[7];
    dfs(graph, 1, isVisited);
  }

  private static void dfs(Graph graph, int vertex, boolean[] isVisited) {
    if (isVisited[vertex]) return;
    isVisited[vertex] = true;

    System.out.println(vertex);

    List<Integer> neighbours = graph.nodes.get(vertex);
    for (int neigh : neighbours) {
      if (!isVisited[neigh]) dfs(graph, neigh, isVisited);
    }
  }
}
