package Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjList {

  static class Graph {
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


  public static void main(String[] args) {
    Graph graph = new Graph(6);
    graph.addEdge(0, 1, false);
    graph.addEdge(0, 4, false);
    graph.addEdge(2, 1, false);
    graph.addEdge(3, 4, false);
    graph.addEdge(4, 5, false);
    graph.addEdge(2, 3, false);
    graph.addEdge(3, 5, false);

    graph.print();
  }

}
