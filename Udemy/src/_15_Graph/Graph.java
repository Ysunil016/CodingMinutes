package _15_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

  int[] shortest(Graph graph, int vertex) {
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
