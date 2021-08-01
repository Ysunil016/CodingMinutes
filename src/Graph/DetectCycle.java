package Graph;

public class DetectCycle {
  public static void main(String[] args) {
    Graph graph = new Graph(6);

    graph.addEdge(0, 1, false);
    graph.addEdge(0, 4, false);
    graph.addEdge(0, 5, false);
    graph.addEdge(1, 2, false);
    graph.addEdge(2, 3, false);
    graph.addEdge(4, 5, false); // Make Cycle

    boolean[] isVisited = new boolean[graph.V];
    System.out.println(hasCycle(graph, 0, isVisited, -1));
  }

  private static boolean hasCycle(Graph graph, int vertex, boolean[] isVisited, int parent) {
    isVisited[vertex] = true;

    for (int nbr : graph.nodes.get(vertex)) {
      if (!isVisited[nbr]) {
        if (hasCycle(graph, nbr, isVisited, vertex)) return true;
      } else if (nbr != parent) return true;
    }

    return false;
  }

}
