package Graph;

import java.util.ArrayList;
import java.util.List;

class Graph {
  int V;
  List<List<Integer>> nodes = new ArrayList<>();

  Graph(int vertices) {
    this.V = vertices;
    for (int i = 0; i < V; i++) nodes.add(new ArrayList<>());
  }

  void addEdge(int source, int destination, boolean isDirected) {
    nodes.get(source).add(destination);
    if (!isDirected)
      nodes.get(destination).add(source);
  }

  void print() {
    for (int vertex = 0; vertex < V; vertex++) {
      System.out.print(vertex + "---> ");
      for (int adj : nodes.get(vertex))
        System.out.print(adj + " ");
      System.out.println();
    }
  }
}
