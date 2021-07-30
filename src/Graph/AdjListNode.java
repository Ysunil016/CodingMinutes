package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AdjListNode {

  static class Node {
    String city;
    List<Node> neighbour;

    Node(String city) {
      this.city = city;
      this.neighbour = new ArrayList<>();
    }
  }

  static class Graph {
    TreeMap<String, Node> hash = new TreeMap<>();

    Graph(List<String> cities) {
      for (String city : cities)
        hash.put(city, new Node(city));
    }

    void addEdge(String source, String destination, boolean isDirected) {
      if (!hash.containsKey(source) || !hash.containsKey(destination)) return;

      Node sourceNode = hash.get(source);
      Node destinationNode = hash.get(destination);

      sourceNode.neighbour.add(destinationNode);
      if (!isDirected)
        destinationNode.neighbour.add(sourceNode);
    }

    void print() {
      for (String city : hash.keySet()) {
        System.out.print(city + " --> ");
        for (Node next : hash.get(city).neighbour)
          System.out.print(next.city + " ");
        System.out.println();
      }
    }

  }


  public static void main(String[] args) {
    Graph graph = new Graph(List.of("Delhi", "Mumbai", "Lucknow", "Dehradun", "Chennai", "Leh", "Kashmir", "Prayag"));
    graph.addEdge("Dehradun", "Delhi", true);
    graph.addEdge("Delhi", "Prayag", true);
    graph.addEdge("Prayag", "Delhi", true);
    graph.addEdge("Delhi", "Dehradun", true);
    graph.addEdge("Delhi", "Mumbai", true);
    graph.addEdge("Mumbai", "Leh", true);
    graph.addEdge("Leh", "Kashmir", true);

    graph.print();
  }

}
